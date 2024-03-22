/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.controller;

import com.nikproj.creditManagerARM.model.CreditRequestModel;
import com.nikproj.creditManagerARM.model.RequestFormModel;
import com.nikproj.creditManagerARM.model.UserModel;
import com.nikproj.creditManagerARM.service.ApprovalRequestService;
import com.nikproj.creditManagerARM.service.CreateCreditRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/cmarm/create_credit_request")
public class CreateCreditRequestController {

    private CreateCreditRequestService createRequestService;
    private ApprovalRequestService approvalRequestService;

    @Autowired
    public CreateCreditRequestController(
            CreateCreditRequestService createRequestService, 
            ApprovalRequestService approvalRequestService) {
        
        this.createRequestService = createRequestService;
        this.approvalRequestService = approvalRequestService;
    }

    @ModelAttribute(name = "request")
    public RequestFormModel request() {
        return new RequestFormModel();
    }

    @GetMapping
    public String showCreateCreditAppPage() {
        return "createCreditRequest";
    }

    @PostMapping//("/new_app")
    public String createNewCreditRequest(RequestFormModel model) {
        System.out.println(model.toString());
        Long requestId = createRequestService.saveRequest(model);
        CreditRequestModel.Status approveStatus = 
                approvalRequestService.approveRequest(requestId);
        
        if(approveStatus == CreditRequestModel.Status.APPROVED){
            return "redirect:/cmarm/request_approved";
        }else{
            return "redirect:/cmarm/request_rejected";
        }
    }
}
