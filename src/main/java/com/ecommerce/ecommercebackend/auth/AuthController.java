package com.ecommerce.ecommercebackend.auth;

import com.ecommerce.ecommercebackend.entity.User;
import com.ecommerce.ecommercebackend.repository.UserRepository;
import com.ecommerce.ecommercebackend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "User already exists";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return "User registered successfully";

    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        return userRepository.findByUsername(username)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .map(user -> jwtUtil.generateToken(user.getUsername()))
                .orElse("Invalid credentials");
    }
}