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

    public List<Apartment> NewApartmentDtoToApartmentEntity(List<NewApartmentDto> dtos) {
        List<Apartment> entities = new ArrayList<>();

        for (NewApartmentDto dto : dtos) {
            Apartment entity = new Apartment();
            ApartmentDetails detailsForEntity = new ApartmentDetails();

            // check if apartmentDetailsExists


//            entity.setUnitNumber(dto.getUnitNumber());
        }
        return null;
    }
}



        // one extra part, if the details of an apartment already exists, you need to get the key and assign it




//        List<Apartment> result = new ArrayList<>();
//
//        for (NewApartmentDto newApartmentDto : requestDtos) {
//            Apartment newApartment = new Apartment();
//
//            ApartmentDetails newApartmentDetails = new ApartmentDetails();
//            ApartmentDetailsDto apartmentDetailsDto = newApartmentDto.getApartmentDetails();
//            long bedrooms = apartmentDetailsDto.getBedrooms();
//            long bathrooms = apartmentDetailsDto.getBathrooms();
//            long parkingSpaces = apartmentDetailsDto.getParkingSpaces();
//
//            List<Apartment> existingDetails = apartmentsRepo.findApartmentByDetails_BedroomsAndDetails_BathroomsAndDetails_ParkingSpaces(bedrooms, bathrooms, parkingSpaces);
//            if (existingDetails.size() == 1) {
//                newApartmentDetails.setApartmentDetailsID(existingDetails.get(0).getDetails().getApartmentDetailsID());
//            }
//
//            newApartmentDetails.setBedrooms(apartmentDetailsDto.getBedrooms());
//            newApartmentDetails.setBathrooms(apartmentDetailsDto.getBathrooms());
//            newApartmentDetails.setParkingSpaces(apartmentDetailsDto.getParkingSpaces());
//
//            newApartment.setUnitNumber(newApartmentDto.getUnitNumber());
//            newApartment.setDetails(newApartmentDetails);
//            result.add(newApartment);
//        }
//
//        return result;
//    }
