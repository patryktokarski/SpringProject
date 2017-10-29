package com.spring.test.dao;

import com.spring.test.model.Role;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleImpl extends AbstractDao<Integer, Role> implements RoleDao {

    public List<Role> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return (List<Role>) criteria.list();
    }

    public Role findById(int id) {
        return getByKey(id);
    }

    public Role findByType(String type) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("type", type));
        return (Role) criteria.uniqueResult();
    }
}
