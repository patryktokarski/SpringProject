package com.spring.test.services;

import com.spring.test.dao.EventDao;
import com.spring.test.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    EventDao eventDao;

    public void create(Event event) {
        eventDao.create(event);
    }

    public void update(Event event) {
        eventDao.update(event);
    }

    public Event findById(int id) {
        return eventDao.findById(id);
    }

    public List<Event> getAll() {
        return eventDao.getAll();
    }

    public void deleteById(int id) {
        eventDao.deleteById(id);
    }
}
