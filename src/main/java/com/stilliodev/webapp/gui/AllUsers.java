package com.stilliodev.webapp.gui;

import com.stilliodev.webapp.model.AppUser;
import com.stilliodev.webapp.model.Bike;
import com.stilliodev.webapp.repo.AppUserDto;
import com.stilliodev.webapp.repo.AppUserRepo;
import com.stilliodev.webapp.repo.BikeRepo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("AllUsers")
public class AllUsers extends VerticalLayout {

    private AppUserRepo userRepo;

    public AllUsers(AppUserRepo userRepo) {
        this.userRepo = userRepo;

        List<AppUserDto> list = userRepo.getAllUser();

        Grid<AppUserDto> grid = new Grid<>(AppUserDto.class);
        grid.setItems(list);
        add(grid);
    }

}
