/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.service.reports;

import com.nikproj.creditManagerARM.model.ContractReportViewForm;
import com.nikproj.creditManagerARM.repository.Impl.ContractDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class AllContractsReportService {

    private ContractDAO contractDAO;

    @Autowired
    public AllContractsReportService(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    public void fillContractList(List<ContractReportViewForm> contracts) {
        List<ContractReportViewForm> contractsFormDB = contractDAO.getAllContracts();
        if (!contractsFormDB.isEmpty()) {
            contracts.addAll(contractsFormDB);
        }
    }

}
