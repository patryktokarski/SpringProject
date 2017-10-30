package com.spring.test.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    public void save(MultipartFile file) {
        if(!file.isEmpty()) {
            try {
                String name = UUID.randomUUID().toString();
                byte[] bytes = file.getBytes();
                String rootPath = System.getProperty("images");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if(!dir.exists()) {
                    dir.mkdirs();
                }
                File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
