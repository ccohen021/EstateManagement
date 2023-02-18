package com.bbdsoftware.estatemanagement.controllers;

import com.bbdsoftware.estatemanagement.dtos.NewVisitDTO;
import com.bbdsoftware.estatemanagement.entities.Code;
import com.bbdsoftware.estatemanagement.entities.User;
import com.bbdsoftware.estatemanagement.entities.Visit;
import com.bbdsoftware.estatemanagement.exceptions.EmailNotFoundException;
import com.bbdsoftware.estatemanagement.exceptions.VisitNotFoundException;
import com.bbdsoftware.estatemanagement.repositories.CodesRepository;
import com.bbdsoftware.estatemanagement.repositories.UsersRepository;
import com.bbdsoftware.estatemanagement.repositories.VisitsRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/visits")
public class VisitsController {

    private final CodesRepository codesRepo;
    private final VisitsRepository visitsRepo;
    private final UsersRepository usersRepo;
    private final Random random = new Random();

    public VisitsController(CodesRepository codesRepo, VisitsRepository visitsRepo, UsersRepository usersRepo) {
        this.codesRepo = codesRepo;
        this.visitsRepo = visitsRepo;
        this.usersRepo = usersRepo;
    }


    @GetMapping("/{email}")
    public Iterable<Visit> getVisitsForEmail(@PathVariable String email) throws EmailNotFoundException {
        if (!usersRepo.existsByEmailAddress(email)) {
            throw new EmailNotFoundException();
        }

        return visitsRepo.findByUserEmailAddress(email);
    }


    @PostMapping
    public Visit createNewVisit(@Valid @RequestBody NewVisitDTO newVisitDTO) throws EmailNotFoundException {
        Optional<User> optionalUser = usersRepo.findByEmailAddress(newVisitDTO.getEmail());

        if (optionalUser.isEmpty()) {
            throw new EmailNotFoundException();
        }

        User user = optionalUser.get();
        Code code = generateCode();

        Visit visit = new Visit();
        visit.setUser(user);
        visit.setCode(code);
        visit.setVisitorsPhoneNumber(newVisitDTO.getVisitorsPhoneNumber());
        visit.setCancelled(false);

        visitsRepo.save(visit);

        return visit;
    }


    @DeleteMapping("/{visitID}")
    public Visit cancelVisit(@PathVariable Integer visitID) throws VisitNotFoundException {
        // get visit from db
        Optional<Visit> optionalVisit = visitsRepo.findById(visitID);
        if (optionalVisit.isEmpty()) {
            throw new VisitNotFoundException();
        }

        Visit visit = optionalVisit.get();
        visit.setCancelled(true);
        return visit;
    }


    private Code generateCode() {
        LocalDateTime currentTime = LocalDateTime.now();
        List<String> activeCodes = codesRepo.findByValidToAfter(currentTime);

        Code code = new Code();
        code.setCode(generateUniqueDigits(activeCodes));
        code.setValidFrom(currentTime);
        code.setValidTo(currentTime);

        return code;
    }


    private String generateUniqueDigits(List<String> activeCodes) {
        String newCode = "";
        do {
            newCode = String.format("%04d", random.nextInt(1000));
        } while (activeCodes.contains(newCode));

        return newCode;
    }
}
