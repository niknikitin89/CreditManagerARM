/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nikproj.creditManagerARM.repository;

import com.nikproj.creditManagerARM.model.entity.ContractModel;
import com.nikproj.creditManagerARM.model.viewModel.ContractReportViewForm;
import com.nikproj.creditManagerARM.model.viewModel.ContractViewForm;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface ContractDAOInterface {
    Long saveContract(ContractModel model, Session session);
    ContractModel findById(Long id);
    void updateContract(ContractModel model, Session session);
    ContractViewForm getFullContractInfoByRequestId(Long requestId);
    List<ContractReportViewForm> getAllContracts();
}
