package com.spring.test.converters;

import com.spring.test.model.Role;
import com.spring.test.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<Object, Role> {

    @Autowired
    RoleService roleService;

    public Role convert(Object object) {
        Integer id = Integer.parseInt((String)object);
        return roleService.findById(id);
    }
}
