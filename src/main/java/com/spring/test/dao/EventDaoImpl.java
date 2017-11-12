package com.spring.test.dao;

import com.spring.test.model.Event;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventDaoImpl extends AbstractDao<Integer, Event> implements EventDao {

    public void create(Event event) {
        persist(event);
    }

    public void update(Event event) {
        merge(event);
    }

    public Event findById(int id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Event> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Event>) criteria.list();
    }

    public void deleteById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Event event = (Event) criteria.uniqueResult();
        delete(event);
    }
}
