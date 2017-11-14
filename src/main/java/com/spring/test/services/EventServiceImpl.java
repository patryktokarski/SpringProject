package com.spring.test.services;

import com.spring.test.dao.EventDao;
import com.spring.test.model.Event;
import com.spring.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
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

    public List<Event> getEventsByEnrolledUserId(int id) {
        return eventDao.getEventsByEnrolledUserId(id);
    }

    public List<Event> getEventsAvailableForUser(int id) {
        return eventDao.getEventsAvailableForUser(id);
    }

    public void enrollUser(User user, Event event) {
        List<User> users = prepareUserList(event);
        users.add(user);
        event.setUsers(users);
        eventDao.update(event);
    }

    private List<User> prepareUserList(Event event) {
        List<User> users;
        if(event.getUsers() == null) {
            users = new ArrayList<User>();
        } else {
            users = event.getUsers();
        }
        return users;
    }

    public void unenrollUser(User user, Event event) {
        List<User> users = event.getUsers();
        Iterator<User> usersIterator = users.iterator();
        while(usersIterator.hasNext()) {
            if(usersIterator.next().getEmail().equals(user.getEmail())) {
                usersIterator.remove();
            }
        }
        eventDao.update(event);
    }
}
