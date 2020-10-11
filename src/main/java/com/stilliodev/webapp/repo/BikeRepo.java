package com.stilliodev.webapp.repo;

import com.stilliodev.webapp.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepo extends JpaRepository <Bike, Long> {


    @Query(value= "SELECT * from Bike where bike.available = true"
            , nativeQuery=true)
    List<Bike> getBikeRent();

    @Query(value= "SELECT * from Bike", nativeQuery=true)
    List<Bike> getAllBike();
}
