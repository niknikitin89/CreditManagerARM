/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.repository.Impl;

import com.nikproj.creditManagerARM.model.entity.ApprovedRequestModel;
import com.nikproj.creditManagerARM.model.entity.ContractModel;
import com.nikproj.creditManagerARM.model.viewModel.ContractReportViewForm;
import com.nikproj.creditManagerARM.model.viewModel.ContractViewForm;
import com.nikproj.creditManagerARM.model.entity.CreditRequestModel;
import com.nikproj.creditManagerARM.model.entity.UserModel;
import com.nikproj.creditManagerARM.repository.ContractDAOInterface;
import com.nikproj.creditManagerARM.util.HibernateSessionManager;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class ContractDAO implements ContractDAOInterface {

    @Override
    public Long saveContract(ContractModel model, Session session) {
        Long id = (Long) session.save(model);
        return id;
    }

    @Override
    public ContractModel findById(Long id) {
        try (Session session = HibernateSessionManager.openSession()) {
            return session.get(ContractModel.class, id);
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
            return null;
        }
    }

    @Override
    public ContractViewForm getFullContractInfoByRequestId(Long requestId) {
        try (Session session = HibernateSessionManager.openSession()) {

            String hql = "from ContractModel where approveRequest.creditRequest.id = :requestId";
            Query<ContractModel> query = session.createQuery(hql);
            query.setParameter("requestId", requestId);
            List<ContractModel> list = query.list();
            if (list.isEmpty()) {
                return null;
            }

            ContractViewForm contract
                    = convertToResultStructure((ContractModel) list.get(0));

            return contract;
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
            return null;
        }
    }

    private ContractViewForm convertToResultStructure(ContractModel contractModel) {
        //Собираем результат
        ContractViewForm contract = new ContractViewForm();
        ApprovedRequestModel approvedRequest = contractModel.getApproveRequest();
        CreditRequestModel creditRequest = approvedRequest.getCreditRequest();
        UserModel user = creditRequest.getUser();

        contract.setId(contractModel.getId());
        contract.setContractDate(contractModel.getContractDate());
        contract.setRequestId(creditRequest.getId());
        contract.setApprovedSum(approvedRequest.getApprovedSum());
        contract.setCreditTerm(approvedRequest.getCreditTerm());
        contract.setFirstName(user.getFirstName());
        contract.setLastName(user.getLastName());
        contract.setPatronymic(user.getPatronymic());
        contract.setPassportSeria(user.getPassportSeria());
        contract.setPassportNumber(user.getPassportNumber());
        contract.setFamilyStatus(user.getFamilyStatus());
        contract.setAddress(user.getAddress());
        contract.setPhone(user.getPhone());

        return contract;
    }

    @Override
    public void updateContract(ContractModel model, Session session) {
        session.update(model);
    }

    @Override
    public List<ContractReportViewForm> getAllContracts() {
        try (Session session = HibernateSessionManager.openSession()) {

            String hql = "from ContractModel";

            Query<ContractModel> query = session.createQuery(hql);
            List<ContractModel> list = query.list();

            List<ContractReportViewForm> resultList = new ArrayList<>();
            for (ContractModel contract : list) {
                ContractReportViewForm result
                        = new ContractReportViewForm(
                                contract.getId(),
                                contract.getApproveRequest().getCreditRequest().getId(),
                                contract.getContractDate(),
                                contract.getStatus(),
                                contract.getSigningDate());
                resultList.add(result);
            }

            return resultList;
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
            return new ArrayList<>();
        }
    }
}
