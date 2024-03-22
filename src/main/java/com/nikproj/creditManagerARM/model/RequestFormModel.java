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
@Data
@NoArgsConstructor
@Component
public class RequestFormModel {
    private UserModel user;
    private CreditRequestModel request;
}
