package com.stilliodev.webapp.controller;


import com.stilliodev.webapp.model.AppUser;
import com.stilliodev.webapp.model.Image;
import com.stilliodev.webapp.repo.ImageRepo;
import com.stilliodev.webapp.service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ImageController {

    private ImageService imageService;
    private ImageRepo imageRepo;

    public ImageController(final ImageService imageService, final ImageRepo imageRepo) {
        this.imageService = imageService;
        this.imageRepo = imageRepo;
    }

    @GetMapping("/upload")
    public String upload(Model model) {
        model.addAttribute("image", new Image());
        return "upload";
    }


    @PostMapping("/upload")
    public String upload(@ModelAttribute(value = "image") Image image) {

        image.setImageAddress(image.getImageAddress());
        imageService.uploadFileAndSaveToDb(image.getImageAddress());

        return "addcomplete";
    }

}
