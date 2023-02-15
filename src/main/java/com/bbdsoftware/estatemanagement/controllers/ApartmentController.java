package com.bbdsoftware.estatemanagement.controllers;

import com.bbdsoftware.estatemanagement.entities.UserApartment;
import com.bbdsoftware.estatemanagement.repositories.UserApartmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {

    private final UserApartmentRepository userApartmentRepository;

    public ApartmentController(UserApartmentRepository userApartmentRepository) {
        this.userApartmentRepository = userApartmentRepository;
    }

    @GetMapping
    public Iterable<UserApartment> getAll() {
        return userApartmentRepository.findAll();
    }

    @GetMapping("/{unitNumber}")
    public Iterable<UserApartment> getOne(@PathVariable long unitNumber) {
        return userApartmentRepository.findAllByApartmentUnitNumber(unitNumber);
    }


}
