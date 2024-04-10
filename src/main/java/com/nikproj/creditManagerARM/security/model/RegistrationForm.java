/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.security.model;

import com.nikproj.creditManagerARM.model.entity.UserModel;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author user
 */
@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Integer passportSeria;   
    private Integer passportNumber;

    public UserModel toUser(PasswordEncoder passwordEncoder) {
        return new UserModel(username, passwordEncoder.encode(password), 
                firstName, lastName, patronymic, 
                passportSeria, passportNumber);
    }
    
}
