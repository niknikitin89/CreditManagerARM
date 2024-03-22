/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.service;

import com.nikproj.creditManagerARM.model.ContractModel;
import com.nikproj.creditManagerARM.model.ContractViewForm;
import com.nikproj.creditManagerARM.repository.ContractDAOInterface;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class ContractBrowseService {

    private ContractDAOInterface contractDAO;

    @Autowired
    public ContractBrowseService(ContractDAOInterface contractDAO) {
        this.contractDAO = contractDAO;
    }

    public ContractViewForm getContractInfo(Long requestId) {
        return contractDAO.getFullContractInfoByRequestId(requestId);
    }

    public void signContract(Long id) {
        ContractModel contract = contractDAO.findById(id);
        contract.setStatus(ContractModel.Status.SIGNED);
        contract.setSigningDate(new Date());
        contractDAO.updateContract(contract);
    }

    public void cancelContract(Long id) {
        ContractModel contract = contractDAO.findById(id);
        contract.setStatus(ContractModel.Status.CANCELED);
        contract.setSigningDate(new Date());
        contractDAO.updateContract(contract);
    }

}
