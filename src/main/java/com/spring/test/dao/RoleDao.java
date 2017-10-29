package com.spring.test.dao;

import com.spring.test.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAll();
    Role findById(int id);
    Role findByType(String type);
}
