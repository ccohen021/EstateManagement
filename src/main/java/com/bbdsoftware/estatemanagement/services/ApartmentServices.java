package com.bbdsoftware.estatemanagement.services;

import com.bbdsoftware.estatemanagement.dto.NewApartmentDto;
import com.bbdsoftware.estatemanagement.dto.TenantDto;
import com.bbdsoftware.estatemanagement.entities.Apartment;
import com.bbdsoftware.estatemanagement.entities.UserApartment;
import com.bbdsoftware.estatemanagement.exceptions.UnitExistsException;
import com.bbdsoftware.estatemanagement.exceptions.UnitNotFoundException;
import com.bbdsoftware.estatemanagement.mappers.ApartmentMappers;
import com.bbdsoftware.estatemanagement.repositories.ApartmentsRepository;
import com.bbdsoftware.estatemanagement.repositories.UserApartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentServices {

    private final ApartmentsRepository apartmentsRepo;
    private final UserApartmentRepository userApartmentRepo;
    private final ApartmentMappers mappers;

    public ApartmentServices(ApartmentsRepository apartmentsRepo, UserApartmentRepository userApartmentRepo, ApartmentMappers mappers) {
        this.apartmentsRepo = apartmentsRepo;
        this.userApartmentRepo = userApartmentRepo;
        this.mappers = mappers;
    }


    public Apartment getApartment(long unitNumber) {
        return apartmentsRepo.findById(unitNumber).orElseThrow(UnitNotFoundException::new);
    }


    public List<TenantDto> getTenantsForUnitNumber(long unitNumber, Optional<Boolean> current) {
        // validation
        if (!apartmentsRepo.existsById(unitNumber)) {
            throw new UnitNotFoundException();
        }

        Iterable<UserApartment> apartmentsAndUsers = findResidents(unitNumber, current);
        return mappers.userApartmentEntityToTenantsDto(apartmentsAndUsers);
    }


    public Iterable<Apartment> addApartment(List<NewApartmentDto> dtos) {
        // validation
        List<String> existingUnits = dtos.stream()
                .map(NewApartmentDto::getUnitNumber)
                .filter(apartmentsRepo::existsById)
                .map(Object::toString)
                .toList();

        if (!existingUnits.isEmpty()) {
            throw new UnitExistsException("UnitNumber(s) [" +  String.join(",", existingUnits) + "] already exists");
        }

        // processing
        List<Apartment> entities = mappers.NewApartmentDtoToApartmentEntity(dtos);
        return entities;

    }


    private Iterable<UserApartment> findResidents(long unitNumber, Optional<Boolean> current) {
        // all residents
        if (current.isEmpty()) {
            return userApartmentRepo.findAllByApartmentUnitNumber(unitNumber);
        }

        // current residents
        if (Boolean.TRUE.equals(current.get())) {
            return userApartmentRepo.findAllByMovedOutIsNullAndApartmentUnitNumber(unitNumber);
        }

        // past residents
        return userApartmentRepo.findAllByMovedOutIsNotNullAndApartmentUnitNumber(unitNumber);
    }


}
