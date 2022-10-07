package com.example.VetApp.service;

import com.example.VetApp.controller.dto.UserRegistrationDto;
import com.example.VetApp.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
