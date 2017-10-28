package com.spring.test.services;

import com.spring.test.model.Role;

import java.util.List;

public interface RoleService {
    Role findById(int id);
    List<Role> getAll();
}
