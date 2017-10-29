package com.spring.test.services;

import com.spring.test.model.PasswordToken;
import com.spring.test.model.User;

public interface PasswordTokenService  {
    void create(PasswordToken passwordToken);
    String generateToken(User user);
    PasswordToken findBToken(String token);
    void removeToken(String token);
}
