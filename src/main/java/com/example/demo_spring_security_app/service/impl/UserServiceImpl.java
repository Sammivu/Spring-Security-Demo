package com.example.demo_spring_security_app.service.impl;

import com.example.demo_spring_security_app.config.JwtService;
import com.example.demo_spring_security_app.dto.*;
import com.example.demo_spring_security_app.entity.UserEntity;
import com.example.demo_spring_security_app.enums.Role;
import com.example.demo_spring_security_app.repository.UserRepository;
import com.example.demo_spring_security_app.service.EmailService;
import com.example.demo_spring_security_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    //Dependency to repository
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //for login
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    //for email
    private  final EmailService emailService;


    @Override
    public AuthResponseDto registerUser(RegistrationDto registrationDto) {
        UserEntity user = UserEntity.builder()
                .firstName(registrationDto.getFirstName())
                .lastName(registrationDto.getLastName())
                .email(registrationDto.getEmail())
                .password(passwordEncoder.encode(registrationDto.getPassword()))
                .role(Role.USER)
                .build();

        //SEND EMAIL ALEART
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(user.getEmail())
                .subject("Account Creation")
                .messageBody("Congratulation! Your Account have been created ")
                .build();
        emailService.sendEmailAlert(emailDetails);


        userRepository.save(user);

        return AuthResponseDto.builder()
                .responseCode("001")
                .responseMessage("Account Created Successfully")
                .registrationInfo(RegistrationInfo.builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .build())
                .build();
    }

    @Override
    public LoginResponse loginUser(LoginRequestDto loginRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequestDto.getEmail(),loginRequestDto.getPassword())
        );

        UserEntity user =userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return LoginResponse.builder()
                .responseCode("002")
                .responseMessage("Login Successfully")
                .loginInfo(LoginInfo.builder().email(user.getEmail())
                        .token(jwtToken)
                        .build())
                .build();

    }
}
