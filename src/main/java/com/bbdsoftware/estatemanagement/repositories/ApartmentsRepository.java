package com.bbdsoftware.estatemanagement.repositories;

import com.bbdsoftware.estatemanagement.entities.Apartment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApartmentsRepository extends CrudRepository<Apartment, Long> {
    List<Apartment> findApartmentByDetails_BedroomsAndDetails_BathroomsAndDetails_ParkingSpaces(long bedrooms, long bathrooms, long parkingSpaces);
}
