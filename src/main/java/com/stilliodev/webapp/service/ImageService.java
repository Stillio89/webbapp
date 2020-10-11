package com.stilliodev.webapp.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.stilliodev.webapp.model.Image;
import com.stilliodev.webapp.repo.ImageRepo;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageService {

    private Cloudinary cloudinary;

    private ImageRepo imageRepo;

   public ImageService(ImageRepo imageRepo) {
       this.imageRepo = imageRepo;
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name","di49tvlkm",
                "api_key","867421233277592",
                "api_secret", "so570_eQyB0rKfInmZM43hvoZ_4"));
    }

    public  String uploadFileAndSaveToDb(String path){
        File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            imageRepo.save(new Image(uploadResult.get("url").toString()));
        } catch (IOException e) {
            //todo
        }
        return uploadResult.get("url").toString();


    }
}
