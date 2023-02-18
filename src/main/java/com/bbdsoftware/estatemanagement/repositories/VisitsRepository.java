package com.bbdsoftware.estatemanagement.repositories;

import com.bbdsoftware.estatemanagement.entities.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitsRepository extends CrudRepository<Visit, Integer> {
    Iterable<Visit> findByUserEmailAddress(String email);
}
