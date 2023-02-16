package com.bbdsoftware.estatemanagement.repositories;

import com.bbdsoftware.estatemanagement.entities.ApartmentDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ApartmentDetailsRepository extends CrudRepository<ApartmentDetails, Long> {

    Optional<ApartmentDetails> findApartmentDetailsByBedroomsAndBathroomsAndParkingSpaces(long bedrooms, long bathrooms, long parkingSpaces);
}
