package com.stilliodev.webapp.controller;


import com.stilliodev.webapp.model.Bike;
import com.stilliodev.webapp.repo.BikeRepo;
import com.stilliodev.webapp.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class BikeController {

    private BikeService bikes;
    private BikeRepo bikeRepo;

    @Autowired
    public BikeController(final BikeService bikes, final BikeRepo bikeRepo) {
        this.bikes = bikes;
        this.bikeRepo = bikeRepo;
    }

    @GetMapping("/all")
    public Iterable<Bike> getAll(Model model) {
        model.addAttribute("bike", model);
        return bikes.findAll();
    }

    @GetMapping("/addbike")
    public String addBike(Model model) {
        model.addAttribute("bike", new Bike());
        return "addbike";
    }

    @PostMapping("/addbike")
    public String addBike(@ModelAttribute(value = "bike") @Valid Bike bike, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("BINDING RESULT ERROR");
            return "addbike";
        } else {
       bikes.addBike(bike);
        }

        return "add-bike-complete";
    }

    @GetMapping()
    public Optional<Bike> getById(@RequestParam Long index) {
        return bikes.findById(index);
    }

    @PutMapping
    public Bike updateBike(@RequestBody Bike bike) {
        return bikes.save(bike);
    }

    @DeleteMapping
    public void deleteBike(@RequestParam Long index) {
        bikes.deleteById(index);
    }



    public List<Bike> get() {
        return bikeRepo.getBikeRent();
    }

    public List<Bike> getA() {
        return bikeRepo.getAllBike();
    }

}

