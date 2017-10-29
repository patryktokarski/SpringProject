package com.spring.test.services;

import com.spring.test.model.User;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {
    void create (User user);
    User findById(int id);
    User findByEmail(String email);
    List<User> getAll();
    void deleteById(int id);
    boolean setRole(User user, String role);
    boolean existsInDb(User user);
    boolean userWithEmailExists(String email, User user);
    void prepareModelForCreate(Model model);
    void prepareModelForEdit(Model model, int id);
    void mergeWithExisting(User user);
    boolean isUserNew(int id);
    void changePassword(User user, String password);

}
