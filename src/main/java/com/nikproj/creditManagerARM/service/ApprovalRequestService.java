/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.service;

import com.nikproj.creditManagerARM.model.ApprovedRequestModel;
import com.nikproj.creditManagerARM.model.ContractModel;
import com.nikproj.creditManagerARM.model.CreditRequestModel;
import com.nikproj.creditManagerARM.repository.ApprovedRequestDAOInterface;
import com.nikproj.creditManagerARM.repository.ContractDAOInterface;
import com.nikproj.creditManagerARM.repository.CreditRequestDAOInterface;
import java.util.Date;
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
    private ApprovedRequestDAOInterface approvedRequestDAO;

    @Autowired
    public ApprovalRequestService(
            CreditRequestDAOInterface creditRequestDAO,
            ContractDAOInterface contractDAO,
            ApprovedRequestDAOInterface approvedRequestDAO) {

        this.creditRequestDAO = creditRequestDAO;
        this.contractDAO = contractDAO;
        this.approvedRequestDAO = approvedRequestDAO;
    }

    public CreditRequestModel.Status approveRequest(Long requestId) {
        //Анализируем заявку и принимаем решение по одобрению
        ApprovedRequestModel approvedRequest = analysisAndDecision(requestId);

        if (approvedRequest != null) {
            //генерируем договор
            Long contract_Id = generateContractForRequest(approvedRequest);

            return CreditRequestModel.Status.APPROVED;
        }

        return CreditRequestModel.Status.REJECTED;
    }

    private ApprovedRequestModel analysisAndDecision(Long requestId) {
        if (Math.random() > 0.5) {
            //Обновляем инфу по статусу заявки
            CreditRequestModel request = creditRequestDAO.findById(requestId);
            request.setRequestStatus(CreditRequestModel.Status.APPROVED);
            creditRequestDAO.updateCreditRequest(request);

            //Вносим данные в перечень одобренных заявок
            ApprovedRequestModel approvedRequest = new ApprovedRequestModel();
            approvedRequest.setCreditRequest(request);
            approvedRequest.setCreditTerm((int) (Math.random() * 12));
            approvedRequest.setApprovedSum(Math.random() * request.getRequestedSum());
            approvedRequestDAO.saveApprovedRequest(approvedRequest);

            return approvedRequest;
        } else {
            return null;
        }
    }

    private Long generateContractForRequest(ApprovedRequestModel approvedRequest) {
        ContractModel contract = new ContractModel();
        contract.setApproveRequest(approvedRequest);
        contract.setContractDate(new Date());
        contract.setStatus(ContractModel.Status.WAIT);
        Long id = contractDAO.saveContract(contract);
        return id;
    }

}
