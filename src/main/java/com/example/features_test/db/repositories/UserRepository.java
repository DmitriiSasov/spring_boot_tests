package com.example.features_test.db.repositories;

import com.example.features_test.db.entities.User;
import com.example.features_test.db.entities.UserStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
