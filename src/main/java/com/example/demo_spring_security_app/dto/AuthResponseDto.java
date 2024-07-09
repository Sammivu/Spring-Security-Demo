package com.example.demo_spring_security_app.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//This class gives some Authentication response message to the backEnd
public class AuthResponseDto {

    private  String responseCode;

    private  String responseMessage;

    //This is called composition and it is giving us the information in the RegistrationInfo
    //Helping us to apply dependency injection.
    private  RegistrationInfo registrationInfo;
}
