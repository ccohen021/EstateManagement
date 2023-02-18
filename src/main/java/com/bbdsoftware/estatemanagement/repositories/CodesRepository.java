package com.bbdsoftware.estatemanagement.repositories;

import com.bbdsoftware.estatemanagement.entities.Code;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CodesRepository extends CrudRepository<Code, Integer> {
    @Query("select c.code from Codes c where c.validFrom > :validTo")
    List<String> findByValidToAfter(LocalDateTime validTo);
}
