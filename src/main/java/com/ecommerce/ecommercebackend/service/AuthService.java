package com.ecommerce.ecommercebackend.service;

import com.ecommerce.ecommercebackend.dto.LoginRequest;
import com.ecommerce.ecommercebackend.dto.RegisterRequest;
import com.ecommerce.ecommercebackend.entity.User;
import com.ecommerce.ecommercebackend.exception.ResourceAlreadyExistsException;
import com.ecommerce.ecommercebackend.repository.UserRepository;
import com.ecommerce.ecommercebackend.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    //  REGISTER
    public String register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ResourceAlreadyExistsException("Email already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");

        userRepository.save(user);

        return "User registered successfully";
    }

    //  LOGIN
    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        //  Token contains email + role
        return jwtUtil.generateToken(user.getEmail(), user.getRole());
    }

    //  ADMIN PROMOTION (SECURE)
    public String makeAdmin(String email, String token) {

        if (!jwtUtil.validateToken(token)) {
            throw new RuntimeException("Unauthorized");
        }

        String role = jwtUtil.extractRole(token);

        if (!"ROLE_ADMIN".equals(role)) {
            throw new RuntimeException("Only admin can perform this action");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setRole("ROLE_ADMIN");
        userRepository.save(user);

        return "User promoted to ADMIN";
    }
}