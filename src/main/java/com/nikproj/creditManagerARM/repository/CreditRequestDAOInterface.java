/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nikproj.creditManagerARM.repository;

import com.nikproj.creditManagerARM.model.CreditRequestModel;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface CreditRequestDAOInterface {
    Long saveCreditRequest(CreditRequestModel model);
    CreditRequestModel findById(Long id);

    public void updateCreditRequest(CreditRequestModel request);
}
