package com.example.springboothibernatecrud.service;

import com.example.springboothibernatecrud.entity.User;
import com.example.springboothibernatecrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(int id, User user) {
        Optional<User> existing = userRepository.findById(id);
        if (existing.isPresent()) {
            User u = existing.get();
            u.setName(user.getName());
            u.setAge(user.getAge());
            u.setSalary(user.getSalary());
            return Optional.of(userRepository.save(u));
        }
        return Optional.empty();
    }

    public boolean deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
