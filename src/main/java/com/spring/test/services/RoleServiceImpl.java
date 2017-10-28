package com.spring.test.services;

import com.spring.test.model.Role;
import com.spring.test.models.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    public Role findById(int id) {
        return roleDao.findById(id);
    }

    public List<Role> getAll() {
        return roleDao.getAll();
    }
}
