/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.service.reports;

import com.nikproj.creditManagerARM.model.RequestFullModel;
import com.nikproj.creditManagerARM.repository.CreditRequestDAOInterface;
import com.nikproj.creditManagerARM.repository.Impl.CreditRequestDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class AllRequestsReportService {

    private CreditRequestDAOInterface requesDAO;

    @Autowired
    public AllRequestsReportService(CreditRequestDAOInterface requesDAO) {
        this.requesDAO = requesDAO;
    }
    
    public void fillRequestList(List<RequestFullModel> requests) {
     List<RequestFullModel> requesData = requesDAO.getFullRequestInfo();
        if (!requesData.isEmpty()) {
            requests.addAll(requesData);
        }
    }
}
