package com.bbdsoftware.estatemanagement.repositories;

import com.bbdsoftware.estatemanagement.entities.UserApartment;
import org.springframework.data.repository.CrudRepository;

public interface UserApartmentRepository extends CrudRepository<UserApartment, Long> {
    Iterable<UserApartment> findAllByApartmentUnitNumber(long apartmentUnitNumber);
}
