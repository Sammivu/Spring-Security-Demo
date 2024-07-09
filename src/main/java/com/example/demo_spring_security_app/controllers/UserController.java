package com.example.demo_spring_security_app.controllers;

import com.example.demo_spring_security_app.dto.AuthResponseDto;
import com.example.demo_spring_security_app.dto.LoginRequestDto;
import com.example.demo_spring_security_app.dto.LoginResponse;
import com.example.demo_spring_security_app.dto.RegistrationDto;
import com.example.demo_spring_security_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")

public class UserController {

    private final UserService userService;

    @PostMapping("/register-user")
    public ResponseEntity<AuthResponseDto>registerUser(@RequestBody RegistrationDto registrationDto){
        return ResponseEntity.ok(userService.registerUser(registrationDto));
    }

    @PostMapping("/login-user")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequestDto loginRequestDto){

        return ResponseEntity.ok(userService.loginUser(loginRequestDto));
    }
}
