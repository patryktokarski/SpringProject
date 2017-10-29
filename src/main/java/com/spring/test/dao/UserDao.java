package com.spring.test.dao;

import com.spring.test.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);
    void update(User user);
    User findById(int id);
    User findByEmail(String email);
    List<User> getAll();
    void deleteById(int id);
    User userWithEmailExists(String email, User user);
}
