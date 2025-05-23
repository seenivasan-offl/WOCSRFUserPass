package com.example.WOCSRFUserPass.controller;

import com.example.WOCSRFUserPass.model.User;
import com.example.WOCSRFUserPass.repository.UserRepository;
import com.example.WOCSRFUserPass.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Changed to RestController
@RequestMapping("/api")  // Optional base path for all APIs
public class UserController {

    BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSecurity userSecurity;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userSecurity.getAllUser();
    }

    // Changed to POST for security; accept JSON body instead of URL params
    @PostMapping("/login")
    public String loginUser(@RequestBody User loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return "Login successfully";
        }
        return "Invalid Credentials";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "User already exists";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User successfully added!!";
    }
}
