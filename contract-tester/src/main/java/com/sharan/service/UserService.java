package com.sharan.service;

import com.sharan.model.User;
import com.sharan.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void checkAndSave(User user) {
        List<User> users = userRepository.findAll();
        for (User person : users) {
            if (Objects.equals(person.getName(), user.getName())) {
                System.out.println("user already exist");
                return;
            }
        }
        userRepository.save(user);
    }
}
