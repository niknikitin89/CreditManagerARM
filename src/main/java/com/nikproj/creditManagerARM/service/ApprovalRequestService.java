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
import com.nikproj.creditManagerARM.utilit.HibernateSessionManager;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
            generateContractForRequest(approvedRequest);
            return CreditRequestModel.Status.APPROVED;
        }
        return CreditRequestModel.Status.REJECTED;
    }

    private ApprovedRequestModel analysisAndDecision(Long requestId) {
        if (Math.random() > 0.5) {
            ApprovedRequestModel approvedRequest = approve(requestId);
            return approvedRequest;
        } else {
            reject(requestId);
            return null;
        }
    }

    private void reject(Long requestId) {
        CreditRequestModel request = creditRequestDAO.findById(requestId);
        request.setRequestStatus(CreditRequestModel.Status.REJECTED);
        try {
            Session session = HibernateSessionManager.openSession();
            Transaction transaction = session.beginTransaction();
            
            creditRequestDAO.updateCreditRequest(request, session);
            
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
        }
    }

    private ApprovedRequestModel approve(Long requestId) {
        //Обновляем инфу по статусу заявки
        CreditRequestModel request = creditRequestDAO.findById(requestId);
        request.setRequestStatus(CreditRequestModel.Status.APPROVED);
        ApprovedRequestModel approvedRequest = new ApprovedRequestModel();
        try {
            Session session = HibernateSessionManager.openSession();
            Transaction transaction = session.beginTransaction();
            
            creditRequestDAO.updateCreditRequest(request, session);
            
            //Вносим данные в перечень одобренных заявок
            approvedRequest.setCreditRequest(request);
            approvedRequest.setCreditTerm((int) (Math.random() * 12));
            approvedRequest.setApprovedSum(Math.random() * request.getRequestedSum());
            approvedRequestDAO.saveApprovedRequest(approvedRequest, session);
            
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
        }
        return approvedRequest;
    }

    private Long generateContractForRequest(ApprovedRequestModel approvedRequest) {
        ContractModel contract = new ContractModel();
        contract.setApproveRequest(approvedRequest);
        contract.setContractDate(new Date());
        contract.setStatus(ContractModel.Status.WAIT);

        Long id = Long.valueOf(-1);
        try {
            Session session = HibernateSessionManager.openSession();
            Transaction transaction = session.beginTransaction();

            id = contractDAO.saveContract(contract, session);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
        }
        return id;
    }

}
