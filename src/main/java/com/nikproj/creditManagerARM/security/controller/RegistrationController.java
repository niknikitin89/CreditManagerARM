/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.security.controller;

import com.nikproj.creditManagerARM.model.Constants;
import com.nikproj.creditManagerARM.repository.UserDAOInterface;
import com.nikproj.creditManagerARM.security.model.RegistrationForm;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@AllArgsConstructor
@Controller
@RequestMapping(name = Constants.PAGE_URL_REGISTRATION)
public class RegistrationController {
    
    private UserDAOInterface repository; 
    private PasswordEncoder passwordEncoder;
    
    @GetMapping
    public String showRegistrationPage(){
        return "registration";
    }
    
    @PostMapping
    public String processRegistration(RegistrationForm form){
        repository.saveUser(form.toUser(passwordEncoder));
        return "redirect:" + Constants.PAGE_URL_LOGIN;
    }
}
