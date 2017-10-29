package com.spring.test.services;

import com.spring.test.dao.PasswordTokenDao;
import com.spring.test.model.PasswordToken;
import com.spring.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class PasswordTokenServiceImpl implements PasswordTokenService {

    @Autowired
    PasswordTokenDao passwordTokenDao;

    public void create(PasswordToken passwordToken) {
        passwordTokenDao.create(passwordToken);
    }

    public String generateToken(User user) {
        String token = UUID.randomUUID().toString();
        PasswordToken userToken = new PasswordToken(token, user);
        create(userToken);
        return null;
    }

    public PasswordToken findBToken(String token) {
        return passwordTokenDao.findByToken(token);
    }

    public void removeToken(String token) {
        passwordTokenDao.delete(token);
    }
}
