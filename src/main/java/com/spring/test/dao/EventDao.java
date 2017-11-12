package com.spring.test.dao;

import com.spring.test.model.Event;

import java.util.List;

public interface EventDao {
    void create(Event event);
    void update(Event event);
    Event findById(int id);
    List<Event> getAll();
    void deleteById(int id);
}
