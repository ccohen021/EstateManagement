package com.bbdsoftware.estatemanagement.mappers;

import com.bbdsoftware.estatemanagement.dto.NewApartmentDto;
import com.bbdsoftware.estatemanagement.dto.PartialApartmentDto;
import com.bbdsoftware.estatemanagement.dto.TenantDto;
import com.bbdsoftware.estatemanagement.entities.Apartment;
import com.bbdsoftware.estatemanagement.entities.UserApartment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApartmentMappers {

    public List<TenantDto> userApartmentEntityToTenantsDto(Iterable<UserApartment> entities) {
        List<TenantDto> dtos = new ArrayList<>();
        for (UserApartment entity : entities) {
            TenantDto dto = new TenantDto();
            dto.setMovedIn(entity.getMovedIn());
            dto.setMovedOut(entity.getMovedOut());

            dto.setUser(entity.getUser());
            dtos.add(dto);
        }
        return dtos;
    }

    public List<Apartment> newApartmentDtoToApartmentEntity(List<NewApartmentDto> dtos) {
        List<Apartment> entities = new ArrayList<>();

        for (NewApartmentDto dto : dtos) {
            Apartment entity = new Apartment();
            entity.setBedrooms(dto.getBedrooms());
            entity.setBathrooms(dto.getBathrooms());
            entity.setParkingSpaces(dto.getParkingSpaces());
            entity.setUnitNumber(dto.getUnitNumber());
            entities.add(entity);
        }

        return entities;
    }

    public Apartment partialApartmentDtoToApartmentEntity(Apartment entity, PartialApartmentDto dto) {
        // map all fields not null to the entity
        entity.setBedrooms(dto.getBedrooms() == null ? entity.getBedrooms() : dto.getBedrooms());
        entity.setBathrooms(dto.getBathrooms() == null ? entity.getBathrooms() : dto.getBathrooms());
        entity.setParkingSpaces(dto.getParkingSpaces() == null ? entity.getParkingSpaces() : dto.getParkingSpaces());
        return entity;
    }
}
