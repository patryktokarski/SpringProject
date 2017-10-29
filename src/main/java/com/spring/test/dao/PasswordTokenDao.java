package com.spring.test.dao;

import com.spring.test.model.PasswordToken;

public interface PasswordTokenDao {
    void create(PasswordToken passwordToken);
    PasswordToken findByToken(String token);
    void delete(String token);
}
