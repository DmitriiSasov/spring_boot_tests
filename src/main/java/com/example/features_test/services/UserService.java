package com.example.features_test.services;

import com.example.features_test.db.entities.User;
import com.example.features_test.db.entities.UserStatus;
import com.example.features_test.db.repositories.UserRepository;
import com.example.features_test.db.repositories.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserStatusRepository userStatusRepository;


    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public void createUser(User user) {
        user.setUserStatus(userStatusRepository.findByName("активный").orElseThrow(RuntimeException::new));
        userRepository.save(user);
    }

    public void updateUserInfo(User user) {
        User oldUser = userRepository.findByEmail(user.getEmail()).orElseThrow(RuntimeException::new);
        oldUser.setPassword(user.getPassword());
        userRepository.save(oldUser);
    }
}
