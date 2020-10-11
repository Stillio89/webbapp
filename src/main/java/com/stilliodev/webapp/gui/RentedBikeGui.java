package com.stilliodev.webapp.gui;

import com.stilliodev.webapp.model.Bike;
import com.stilliodev.webapp.repo.BikeRepo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("rented")
public class RentedBikeGui extends VerticalLayout {
    private BikeRepo bikeRepo;

    public RentedBikeGui(BikeRepo bikeRepo) {
        this.bikeRepo = bikeRepo;

        List<Bike> list = bikeRepo.getBikeRent();

        Grid<Bike> grid = new Grid<>(Bike.class);
        grid.setItems(list);
        add(grid);
    }
}
