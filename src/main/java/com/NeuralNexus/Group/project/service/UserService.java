package com.NeuralNexus.Group.project.service;


import com.NeuralNexus.Group.project.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
