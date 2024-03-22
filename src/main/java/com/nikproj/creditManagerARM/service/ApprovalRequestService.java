/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.service;

import com.nikproj.creditManagerARM.model.ContractModel;
import com.nikproj.creditManagerARM.model.CreditRequestModel;
import com.nikproj.creditManagerARM.repository.ContractDAOInterface;
import com.nikproj.creditManagerARM.repository.CreditRequestDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class ApprovalRequestService {

    private CreditRequestDAOInterface creditRequestDAO;
    private ContractDAOInterface contractDAO;

    @Autowired
    public ApprovalRequestService(
            CreditRequestDAOInterface creditRequestDAO,
            ContractDAOInterface contractDAO) {
        
        this.creditRequestDAO = creditRequestDAO;
        this.contractDAO = contractDAO;
    }
    
    public CreditRequestModel.Status approveRequest(Long requestId) {
        //Анализируем заявку и принимаем решение по одобрению
        CreditRequestModel.Status result = analysisAndDecision(requestId);

        if (result == CreditRequestModel.Status.APPROVED) {
            //генерируем договор
            generateContractForRequest(requestId);
        }
        
        return result;
    }

    private CreditRequestModel.Status analysisAndDecision(Long requestId) {
//        if (Math.random() > 0.5) {
            CreditRequestModel request = creditRequestDAO.findById(requestId);
            request.setRequestStatus(CreditRequestModel.Status.APPROVED);
            creditRequestDAO.updateCreditRequest(request);
            return request.getRequestStatus();
//        } else {
//            return CreditRequestModel.Status.REJECTED;
//        }
    }

    private void generateContractForRequest(Long requestId) {
        ContractModel contract = new ContractModel();
//        contract
    }

}
