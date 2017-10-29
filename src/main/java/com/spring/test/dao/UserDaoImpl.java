package com.spring.test.dao;

import com.spring.test.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

    public void create(User user) {
        persist(user);
    }

    public void update(User user) {
        merge(user);
    }

    public User findById(int id) {
        return getByKey(id);
    }

    public User findByEmail(String email) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));
        return (User) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<User>) criteria.list();
    }

    public void deleteById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id",id));
        User user = (User) criteria.uniqueResult();
        delete(user);
    }

    public User userWithEmailExists(String email, User user) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));
        criteria.add(Restrictions.not(Restrictions.eq("id", user.getId())));
        return (User) criteria.uniqueResult();
    }
}
