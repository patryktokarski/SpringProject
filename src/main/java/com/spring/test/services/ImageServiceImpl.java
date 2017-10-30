package com.spring.test.services;

import com.spring.test.dao.ImageDao;
import com.spring.test.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageDao imageDao;

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
                String path = dir.getAbsolutePath() + File.separator + name;
                File serverFile = new File(path);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                Image image = new Image(path);
                imageDao.create(image);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
