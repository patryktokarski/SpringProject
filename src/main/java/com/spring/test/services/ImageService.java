package com.spring.test.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void save(MultipartFile file);
}
