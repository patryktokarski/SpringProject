package com.spring.test.dao;

import com.spring.test.model.Image;

public interface ImageDao {
    void create(Image image);
    void update(Image image);
    void deleteById(int id);
}
