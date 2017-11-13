package com.spring.test.services;

import com.spring.test.model.Event;

import java.util.List;

public interface EventService {
    void create(Event event);
    void update(Event event);
    Event findById(int id);
    List<Event> getAll();
    void deleteById(int id);
    List<Event> getEventsByEnrolledUserId(int id);
    List<Event> getEventsAvailableForUser(int id);
}
