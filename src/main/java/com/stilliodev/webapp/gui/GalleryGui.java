package com.stilliodev.webapp.gui;

import com.stilliodev.webapp.model.Image;
import com.stilliodev.webapp.repo.ImageRepo;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("gallery")
public class GalleryGui extends VerticalLayout {

private ImageRepo imageUpload;

@Autowired
    public GalleryGui(ImageRepo imageUpload){
    this.imageUpload = imageUpload;

    List<Image> all = imageUpload.findAll();

    all.stream().forEach(element->{
        com.vaadin.flow.component.html.Image image =
                new com.vaadin.flow.component.html.Image(element.getImageAddress(),"brak");
        add(image);
    });
}

}
