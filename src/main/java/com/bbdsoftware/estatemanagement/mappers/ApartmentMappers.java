package com.bbdsoftware.estatemanagement.mappers;

import com.bbdsoftware.estatemanagement.dto.NewApartmentDto;
import com.bbdsoftware.estatemanagement.dto.TenantDto;
import com.bbdsoftware.estatemanagement.entities.Apartment;
import com.bbdsoftware.estatemanagement.entities.ApartmentDetails;
import com.bbdsoftware.estatemanagement.entities.UserApartment;
import com.bbdsoftware.estatemanagement.repositories.ApartmentDetailsRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ApartmentMappers {

    private final ApartmentDetailsRepository apartmentDetailsRepo;

    public ApartmentMappers(ApartmentDetailsRepository apartmentDetailsRepo) {
        this.apartmentDetailsRepo = apartmentDetailsRepo;
    }

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

    // side effect :(
    public List<Apartment> NewApartmentDtoToApartmentEntity(List<NewApartmentDto> dtos) {
        List<Apartment> entities = new ArrayList<>();

        for (NewApartmentDto dto : dtos) {
            Apartment entity = new Apartment();

            // check if apartmentDetailsExists
            Optional<ApartmentDetails> optionalEntityDetails = apartmentDetailsRepo.findApartmentDetailsByBedroomsAndBathroomsAndParkingSpaces(
                    dto.getBedrooms(),
                    dto.getBathrooms(),
                    dto.getParkingSpaces()
            );

            // if exists, use those details instead of inserting a new apartmentDetails entity
            if (optionalEntityDetails.isPresent()) {
                entity.setDetails(optionalEntityDetails.get());
            } else {
                ApartmentDetails detailsForEntity = new ApartmentDetails();
                detailsForEntity.setBedrooms(dto.getBedrooms());
                detailsForEntity.setBathrooms(dto.getBathrooms());
                detailsForEntity.setParkingSpaces(dto.getParkingSpaces());
                // in case the user had a list with 4 of the same apartmentDetails but all new
                entity.setDetails(apartmentDetailsRepo.save(detailsForEntity));
            }

            entity.setUnitNumber(dto.getUnitNumber());
            entities.add(entity);
        }
        return entities;
    }
}
