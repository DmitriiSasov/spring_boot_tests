package com.example.features_test.db.repositories;

import com.example.features_test.db.entities.UserStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserStatusRepository extends CrudRepository<UserStatus, Long> {

    Optional<UserStatus> findByName(String name);


}
