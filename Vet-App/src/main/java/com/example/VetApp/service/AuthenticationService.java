package com.example.VetApp.service;

import com.example.VetApp.entity.User;
import com.example.VetApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public Authentication getAuthentication(){
        return  SecurityContextHolder.getContext().getAuthentication();

    }
    //Authentication(kimlik doğrulama) ve Authorization(yetki kontrolu)

    public String getCurrentUserName(){
        UserDetails userDetails= (UserDetails) getAuthentication().getPrincipal();
        //şuanda  auth olmuş kişiyi döndürüyor  getCuuren
        return  userDetails.getUsername();
    }

    public long getCurrentUId(){
        UserDetails userDetails= (UserDetails) getAuthentication().getPrincipal();
        User user=userRepository.findByEmail(userDetails.getUsername());
        return  user.getId();
    }
}
