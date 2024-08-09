package com.viniwebs.workshop.services;

import com.viniwebs.workshop.domain.User;
import com.viniwebs.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(String id) {
        User user = findById(id);
        userRepository.delete(user);
    }

    public void update(User user) {
        User userToUpdate = findById(user.getId());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userRepository.save(user);
    }

}
