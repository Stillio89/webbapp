package com.stilliodev.webapp.repo;

import com.stilliodev.webapp.model.AppUser;
import com.stilliodev.webapp.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {

   Optional <AppUser> findByUsername(String username);

   @Query(value= "SELECT ID as Id, USERNAME as Username, ROLE as Role, MAIL as Mail from App_User", nativeQuery=true)
   List<AppUserDto> getAllUser();

   

}
