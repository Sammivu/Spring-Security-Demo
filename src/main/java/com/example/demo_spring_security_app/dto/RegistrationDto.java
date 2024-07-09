package com.example.demo_spring_security_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//This class handles the request coming from our user,
public class RegistrationDto {


    private  String firstName;

    private  String lastName;

    private String email;

    private String password;
}
