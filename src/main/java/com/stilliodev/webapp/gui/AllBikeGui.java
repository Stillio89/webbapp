package com.stilliodev.webapp.gui;

import com.stilliodev.webapp.model.Bike;
import com.stilliodev.webapp.repo.BikeRepo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("allbike")
public class AllBikeGui extends VerticalLayout {

    private BikeRepo bikeRepo;


    public AllBikeGui(BikeRepo bikeRepo) {
        this.bikeRepo = bikeRepo;

        List<Bike> list = bikeRepo.getAllBike();

        Grid<Bike> grid = new Grid<>(Bike.class);
        grid.setItems(list);
        add(grid);
    }

}
