package com.crud.service;

import com.crud.model.User;
import com.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findUserByUserId(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User existingUser = userRepository.findUserByUserId(user.getId());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteByUserId(id);
    }

}
