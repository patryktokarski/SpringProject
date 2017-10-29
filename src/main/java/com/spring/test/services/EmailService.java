package com.spring.test.services;

public interface EmailService {
    void sendMessage(String to, String subject, String contents);
}
