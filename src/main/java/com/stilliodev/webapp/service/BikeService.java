package com.stilliodev.webapp.service;


import com.stilliodev.webapp.model.AppUser;
import com.stilliodev.webapp.model.Bike;
import com.stilliodev.webapp.repo.BikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BikeService {

    private BikeRepo bikeRepo;

    @Autowired
    public BikeService(final BikeRepo bikeRepo) {
        this.bikeRepo = bikeRepo;
    }

    public Optional<Bike> findById(Long id){
        return bikeRepo.findById(id);
    }

    public Iterable<Bike> findAll(){
        return bikeRepo.findAll();
    }

    public Bike save (Bike bike){
        return bikeRepo.save(bike);
    }

    public void deleteById (Long id){
        bikeRepo.deleteById(id);
    }

    public void addBike(Bike bike) {
       bikeRepo.save(bike);


    }

}
