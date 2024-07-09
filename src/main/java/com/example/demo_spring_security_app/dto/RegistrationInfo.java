package com.example.demo_spring_security_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

// This is the response our database sends to the client
public class RegistrationInfo {

    private String firstName;

    private String lastName;

    private  String email;

}
