package com.bbdsoftware.estatemanagement.repositories;

import com.bbdsoftware.estatemanagement.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface  UsersRepository extends CrudRepository<User, Integer> {
    boolean existsByEmailAddress(String emailAddress);
    Optional<User> findByEmailAddress(String emailAddress);
}
