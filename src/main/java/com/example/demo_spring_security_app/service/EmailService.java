package com.example.demo_spring_security_app.service;

import com.example.demo_spring_security_app.dto.EmailDetails;

public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
}
