/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nikproj.creditManagerARM.repository;

import com.nikproj.creditManagerARM.model.ContractModel;
import com.nikproj.creditManagerARM.model.ContractViewForm;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface ContractDAOInterface {
    Long saveContract(ContractModel model);
    ContractModel findById(Long id);

    public void updateContract(ContractModel model);
    public ContractViewForm getFullContractInfoByRequestId(Long requestId);
}
