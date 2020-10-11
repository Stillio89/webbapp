package com.stilliodev.webapp;


import com.stilliodev.webapp.model.AppUser;
import com.stilliodev.webapp.model.Bike;
import com.stilliodev.webapp.repo.AppUserRepo;
import com.stilliodev.webapp.repo.BikeRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Start {


    private AppUserRepo appUserRepo;
    private BikeRepo bikeRepo;

    Start(final AppUserRepo appUserRepo, PasswordEncoder passwordEncoder, BikeRepo bikeRepo) {

        AppUser appUser = new AppUser();
        appUser.setUsername("Stillio");
        appUser.setPassword(passwordEncoder.encode( "AppkaDoZrobienia"));
        appUser.setRole("ROLE_ADMIN");
        appUser.setMail("amanagamacha@gmail.com");
        appUser.setEnabled(true);
        appUserRepo.save(appUser);

        AppUser appUser2 = new AppUser();
        appUser2.setUsername("PiBD");
        appUser2.setPassword(passwordEncoder.encode( "Baza"));
        appUser2.setRole("ROLE_USER");
        appUser2.setMail("amanagamacha@gmail.com");
        appUser2.setEnabled(true);
        appUserRepo.save(appUser2);

        Bike bike1 = new Bike("Giant","Hellfire","City", 23,true);
        Bike bike2 = new Bike("Kross","Level","MTB", 28,false);
        bikeRepo.save(bike1);
        bikeRepo.save(bike2);
    }


}
