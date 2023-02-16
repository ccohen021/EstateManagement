package com.bbdsoftware.estatemanagement.repositories;

import com.bbdsoftware.estatemanagement.entities.Apartment;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentsRepository extends CrudRepository<Apartment, Long> {
}
