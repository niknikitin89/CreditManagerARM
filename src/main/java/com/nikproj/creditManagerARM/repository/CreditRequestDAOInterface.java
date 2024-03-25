/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nikproj.creditManagerARM.repository;

import com.nikproj.creditManagerARM.model.CreditRequestModel;
import com.nikproj.creditManagerARM.model.RequestFullModel;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface CreditRequestDAOInterface {
    Long saveCreditRequest(CreditRequestModel model, Session session);
    CreditRequestModel findById(Long id);
    void updateCreditRequest(CreditRequestModel request, Session session);
    List<RequestFullModel> getFullRequestInfo();
}
