package com.spring.test.services;

import com.spring.test.model.Role;
import com.spring.test.model.State;
import com.spring.test.model.User;
import com.spring.test.dao.RoleDao;
import com.spring.test.dao.UserDao;
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
            model.addAttribute("create", true);
            model.addAttribute("stateList", State.values());
        }
    }

    public void prepareModelForEdit(Model model, int id) {
        if(!model.containsAttribute("user")) {
            User user = findById(id);
            model.addAttribute("user", user);
            model.addAttribute("create", false);
            model.addAttribute("stateList", State.values());
        }
    }

    public void mergeWithExisting(User user) {
        User existingUser = findById(user.getId());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        if(user.getPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        existingUser.setState(user.getState());
        existingUser.setRoles(user.getRoles());
        userDao.update(existingUser);
    }

    public boolean isUserNew(int id) {
        return id == 0;
    }

    public void changePassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        userDao.update(user);
    }
}
