/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nikproj.creditManagerARM.repository;

import com.nikproj.creditManagerARM.model.UserModel;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface UserDAOInterface {
    
    Long saveUser(UserModel model, Session session);
    UserModel findById(Long id);
    List<UserModel> getAllUsers();
    List<UserModel> findByFIOPassportPhone(String firstName, String lastName, String patronymic, Integer passportSeria, Integer passportNumber, String phone);
    
    
}
