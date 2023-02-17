package com.bbdsoftware.estatemanagement.controllers;

import com.bbdsoftware.estatemanagement.dto.NewApartmentDto;
import com.bbdsoftware.estatemanagement.dto.PartialApartmentDto;
import com.bbdsoftware.estatemanagement.dto.TenantDto;
import com.bbdsoftware.estatemanagement.entities.Apartment;
import com.bbdsoftware.estatemanagement.services.ApartmentServices;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/apartments")
public class ApartmentsController {

    private final ApartmentServices services;

    public ApartmentsController(ApartmentServices services) {
        this.services = services;
    }


    @GetMapping("/{unitNumber}")
    public Apartment getApartment(@PathVariable long unitNumber) {
        return services.getApartment(unitNumber);
    }


    @GetMapping("/{unitNumber}/tenants")
    public List<TenantDto> getTenantsFromUnit(@PathVariable long unitNumber, @RequestParam Optional<Boolean> current) {
        return services.getTenantsForUnitNumber(unitNumber, current);
    }


    @PostMapping()
    public Iterable<Apartment> addApartments(@Valid @RequestBody List<@Valid NewApartmentDto> dtos) {
        return services.addApartments(dtos);
    }


    @PatchMapping("/{unitNumber}")
    public Apartment editApartment(@RequestBody @Valid PartialApartmentDto dto) {
        return services.editApartment(dto);
    }
}
