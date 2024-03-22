/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.service;

import com.nikproj.creditManagerARM.model.Constants;
import com.nikproj.creditManagerARM.model.CreditRequestModel;
import com.nikproj.creditManagerARM.model.RequestFormModel;
import com.nikproj.creditManagerARM.model.UserModel;
import com.nikproj.creditManagerARM.repository.CreditRequestDAOInterface;
import com.nikproj.creditManagerARM.repository.UserDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class CreateCreditRequestService {

    private final UserDAOInterface userDAO;
    private final CreditRequestDAOInterface creditRequestDAO;

    @Autowired
    public CreateCreditRequestService(UserDAOInterface userDAO, CreditRequestDAOInterface creditRequestDAO) {
        this.userDAO = userDAO;
        this.creditRequestDAO = creditRequestDAO;
    }

    public Long saveRequest(RequestFormModel model) {
        //Сохраняем пользователя
        UserModel user = model.getUser();
        Long userID = userDAO.saveUser(user);
        if (userID < 0 ) {
            System.err.println(Constants.ERR_SAVE_DATABASE);
            return Long.valueOf(-1);
        }
        
        //Сохраняем информацию по заявке
        CreditRequestModel request = model.getRequest();
        request.setUserId(userID);
        request.setRequestStatus(CreditRequestModel.Status.WAIT);
        Long requestID = creditRequestDAO.saveCreditRequest(request);
        if (requestID < 0 ) {
            System.err.println(Constants.ERR_SAVE_DATABASE);
            return Long.valueOf(-1);
        }
        
        return requestID;
    }

}
