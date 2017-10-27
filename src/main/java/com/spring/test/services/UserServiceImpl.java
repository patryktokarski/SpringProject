package com.spring.test.services;

import com.spring.test.model.Role;
import com.spring.test.model.User;
import com.spring.test.models.RoleDao;
import com.spring.test.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.create(user);
    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    public boolean setRole(User user, String roleType) {
        Role role = roleDao.findByType(roleType);
        if(role == null) {
            return false;
        }
        Set<Role> roles = prepareRolesSet(user);
        roles.add(role);
        user.setRoles(roles);
        return true;
    }

    private Set<Role> prepareRolesSet(User user) {
        Set<Role> roles;
        if(user.getRoles() == null) {
            roles = new HashSet<Role>();
        } else {
            roles = user.getRoles();
        }
        return roles;
    }

    public boolean existsInDb(User user) {
        if(user.getId() == 0) {
            return false;
        }
        return true;
    }

    public boolean userWithEmailExists(String email, User user) {
        if(userDao.userWithEmailExists(email, user) == null) {
            return false;
        }
        return true;
    }

    public void prepareModelForCreate(Model model) {
        if(!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }
    }
}
