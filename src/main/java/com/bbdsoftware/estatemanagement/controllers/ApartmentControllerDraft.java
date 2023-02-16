package com.bbdsoftware.estatemanagement.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apartments")
public class ApartmentControllerDraft {

//    private final UserApartmentRepository userApartmentRepo;
//    private final ApartmentsRepository apartmentsRepo;
//
//    public ApartmentControllerDraft(UserApartmentRepository userApartmentRepo, ApartmentsRepository apartmentsRepo) {
//        this.userApartmentRepo = userApartmentRepo;
//        this.apartmentsRepo = apartmentsRepo;
//    }
//
//    @GetMapping
//    public Iterable<UserApartment> getAll() {
//        return userApartmentRepo.findAllByOrderByApartmentUnitNumberAsc();
//    }
//
//    @GetMapping("/{unitNumber}")
//    public Iterable<UserApartment> getOne(@PathVariable Long unitNumber) {
//        return userApartmentRepo.findAllByApartmentUnitNumber(unitNumber);
//    }
//
//    @GetMapping("/tenants")
//    public Iterable<UserApartment> getTenantsForApartments(@RequestParam boolean current) {
//        if (current) {
//            return userApartmentRepo.findAllByMovedOutIsNull();
//        }
//
//        return userApartmentRepo.findAllByMovedOutIsNotNull();
//    }
//
//    @PatchMapping("/{unitNumber}/tenants")
//    public Iterable<UserApartment> tenantMovedOut(@PathVariable Long unitNumber, @RequestBody Date sqlDate) {
//        Iterable<UserApartment> currentTenants = userApartmentRepo.findAllByMovedOutIsNullAndApartmentUnitNumber(unitNumber);
//
//        for (UserApartment currentTenant : currentTenants) {
//            currentTenant.setMovedOut(sqlDate);
//            userApartmentRepo.save(currentTenant);
//        }
//
//        return userApartmentRepo.findAllByApartmentUnitNumber(unitNumber);
//    }
//
//
//    @PostMapping("/{unitNumber}/tenants")
//    public Iterable<UserApartment> addNewTenantsToApartment(@PathVariable long unitNumber, @Valid @RequestBody List<MoveInDto> moveInDtos) {
//        // check if unitNumber exists
//        Optional<Apartment> optionalApartment = apartmentsRepo.findById(unitNumber);
//        if (optionalApartment.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//
//        // add them as a user if they don't exist
//        List<UserApartment> newUserApartments = new ArrayList<>();
//        for (MoveInDto moveInDto : moveInDtos) {
//            User newUser = new User();
//            newUser.setFirstName(moveInDto.firstName());
//            newUser.setLastName(moveInDto.lastName());
//            newUser.setPhoneNumber(moveInDto.phoneNumber());
//            newUser.setEmailAddress(moveInDto.emailAddress());
//
//            // Create a UserApartment record for the db
//            UserApartment newUserApartment = new UserApartment();
//            newUserApartment.setApartment(optionalApartment.get());
//            newUserApartment.setUser(newUser);
//            newUserApartment.setMovedIn(moveInDto.moveInDate() == null ? new Date(System.currentTimeMillis()) : moveInDto.moveInDate());
//            newUserApartments.add(newUserApartment);
//        }
//
//        return userApartmentRepo.saveAll(newUserApartments);
//    }
//
//    @PostMapping("/apartments")
//    public Iterable<Apartment> addNewApartments(@Valid @RequestBody List<ApartmentDto> apartmentDto) {
//        return null;
//    }
}
