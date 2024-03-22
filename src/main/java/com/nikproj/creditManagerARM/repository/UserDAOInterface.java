/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nikproj.creditManagerARM.repository;

import com.nikproj.creditManagerARM.model.UserModel;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface UserDAOInterface {
    
    Long saveUser(UserModel model);
    UserModel findById(Long id);
    
}
