package com.ecommerce.ecommercebackend.auth;

import com.ecommerce.ecommercebackend.dto.LoginRequest;
import com.ecommerce.ecommercebackend.dto.RegisterRequest;
import com.ecommerce.ecommercebackend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //  REGISTER
    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    //  LOGIN
    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }

    //  MAKE ADMIN (SECURED)
    @PutMapping("/make-admin/{email}")
    public String makeAdmin(@PathVariable String email,
                            @RequestHeader("Authorization") String authHeader) {

        String token = authHeader.substring(7);

        return authService.makeAdmin(email, token);
    }
}