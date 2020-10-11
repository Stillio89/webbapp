package com.stilliodev.webapp.service;

import com.stilliodev.webapp.model.AppUser;
import com.stilliodev.webapp.model.Bike;
import com.stilliodev.webapp.model.Token;
import com.stilliodev.webapp.repo.AppUserRepo;
import com.stilliodev.webapp.repo.TokenRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.UUID;

@Service
public class UserService {

    private TokenRepo tokenRepo;

    private MailService mailService;
    private AppUserRepo appUserRepo;
    private PasswordEncoder passwordEncoder;

    public UserService(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder, TokenRepo tokenRepo,MailService mailService) {
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepo = tokenRepo;
        this.mailService = mailService;
    }

    public void addUser(AppUser appUser) {
        appUser.setPassword(appUser.getPassword());
        appUser.setRole("ROLE_USER");
        appUserRepo.save(appUser);
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepo.save(appUser);
        sendToken(appUser);

    }


    private void sendToken(AppUser appUser) {
        String tokenValue = UUID.randomUUID().toString();

        Token token = new Token();
        token.setValue(tokenValue);
        token.setAppUser(appUser);
        tokenRepo.save(token);

        String url = "http://localhost:8080/token?value=" + tokenValue;
        try {
            mailService.sendMail(appUser.getMail(), "kliknij aby potwierdzic konto!",url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
    public AppUser save (AppUser user){
        return appUserRepo.save(user);
    }

    public void deleteByIdUser (Long id){
        appUserRepo.deleteById(id);
    }
}
