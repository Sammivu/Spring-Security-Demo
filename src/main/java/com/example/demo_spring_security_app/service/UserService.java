package com.example.demo_spring_security_app.service;

import com.example.demo_spring_security_app.dto.AuthResponseDto;
import com.example.demo_spring_security_app.dto.LoginRequestDto;
import com.example.demo_spring_security_app.dto.LoginResponse;
import com.example.demo_spring_security_app.dto.RegistrationDto;

public interface UserService {

    //The AuthResponseDto is to return an object of AuthResponseDto, more like returning the field in AuthResponse
    AuthResponseDto registerUser(RegistrationDto registrationDto);


    LoginResponse loginUser(LoginRequestDto loginRequestDto);
}
