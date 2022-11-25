package com.example.backend.services.email;


import com.example.backend.dtos.EmailDetail;

public interface EmailService {
    int sendSimpleMail(String emailTo, String password);
    String sendMailWithAttachment(EmailDetail details);
}