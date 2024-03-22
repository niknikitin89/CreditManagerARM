/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author user
 */
@NoArgsConstructor
@Component
public class RequestFormModel {
    private UserModel user;
    private CreditRequestModel request;

    public UserModel getUser() {
        return user;
    }

    public CreditRequestModel getRequest() {
        return request;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public void setRequest(CreditRequestModel request) {
        this.request = request;
    }
    
    
}
