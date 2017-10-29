package com.spring.test.dao;

import com.spring.test.model.PasswordToken;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PasswordTokenImpl extends AbstractDao<Integer, PasswordToken> implements PasswordTokenDao {

    public void create(PasswordToken passwordToken) {
        persist(passwordToken);
    }

    public PasswordToken findByToken(String token) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("token", token));
        return (PasswordToken) criteria.uniqueResult();
    }

    public void delete(String token) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("token", token));
        PasswordToken passwordToken = (PasswordToken) criteria.uniqueResult();
        delete(passwordToken);
    }
}
