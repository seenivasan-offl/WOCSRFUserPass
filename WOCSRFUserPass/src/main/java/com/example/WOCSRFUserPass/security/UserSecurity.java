package com.example.WOCSRFUserPass.security;

import com.example.WOCSRFUserPass.model.User;
import com.example.WOCSRFUserPass.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSecurity {
    @Autowired
    UserRepository userRepository;
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
