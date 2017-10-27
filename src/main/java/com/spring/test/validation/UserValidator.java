package com.spring.test.validation;

import com.spring.test.model.User;
import com.spring.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    UserService userService;

    public boolean supports(Class<?> aClass) {
        return false;
    }

    public void validate(Object object, Errors errors) {
        User user = (User) object;
        passwordCheck(user, errors);
        emailCheck(user, errors);
    }

    private void passwordCheck(User user, Errors errors) {
        if(user.getPassword() == null) {
            errors.rejectValue("password", "", "Password field is required");
        } else {
            if(!user.getPassword().equals(user.getPasswordConfirmation())) {
                errors.rejectValue("password", "", "Password and Password Confirmation fields does not match");
            }
        }
    }

    private void emailCheck(User user, Errors errors) {
        if(userService.userWithEmailExists(user.getEmail(), user)) {
            errors.rejectValue("email", "", "Given email is already used");
        }
    }
}
