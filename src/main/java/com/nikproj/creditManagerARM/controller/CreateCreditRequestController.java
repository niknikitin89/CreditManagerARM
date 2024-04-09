/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.controller;

import com.nikproj.creditManagerARM.model.Constants;
import com.nikproj.creditManagerARM.model.entity.CreditRequestModel;
import com.nikproj.creditManagerARM.model.FamilyStatus;
import com.nikproj.creditManagerARM.model.viewModel.RequestFormModel;
import com.nikproj.creditManagerARM.model.entity.UserModel;
import com.nikproj.creditManagerARM.service.ApprovalRequestService;
import com.nikproj.creditManagerARM.service.CreateCreditRequestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author user
 */
@Controller
@SessionAttributes("request")
@RequestMapping(Constants.PAGE_URL_CREATE_REQUEST)
public class CreateCreditRequestController {

    private final CreateCreditRequestService createRequestService;
    private final ApprovalRequestService approvalRequestService;

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

    @ModelAttribute(name = "family_statuses")
    public List<FamilyStatus> familyStatuses() {
        return createRequestService.getFamilyStatuses();
    }

    @GetMapping
    public String showCreateCreditAppPage() {
        return Constants.PAGE_NAME_CREATE_REQUEST;
    }

    @PostMapping
    public String createNewCreditRequest(
            @ModelAttribute(name = "request") RequestFormModel model,
            SessionStatus sessionStatus) {

        //Сохранение запроса
        Long requestId = createRequestService.saveRequest(model);

        //Отправка запроса на одобрение
        CreditRequestModel.Status approveStatus
                = approvalRequestService.approveRequest(requestId);

        if (approveStatus == CreditRequestModel.Status.APPROVED) {
            return "redirect:" + Constants.PAGE_URL_CONTRACT;
        } else {
            sessionStatus.setComplete();
            return "redirect:" + Constants.PAGE_URL_REQUEST_REJECTED;
        }
    }

    @PostMapping(params = "home")
    public String onHomePage(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:" + Constants.PAGE_URL_HOME;
    }

    @GetMapping(params = "default")
    public String setDefaultData(
            @ModelAttribute(name = "request") RequestFormModel model) {
        
        UserModel user = model.getUser();
        user.setFirstName("Иван");
        user.setLastName("Иванов");
        user.setPatronymic("Иванович");
        user.setPassportSeria(1111);
        user.setPassportNumber(222222);
        user.setFamilyStatus("MARRIED");
        user.setAddress("Адрес");
        user.setPhone("89171112233");
        user.setLastWorkPlace("Последнее место работы");
        user.setWorkPeriod(10);
        user.setJobTitle("Должность");

        CreditRequestModel request = model.getRequest();
        request.setRequestedSum(Double.valueOf(12000));

        return "redirect:" + Constants.PAGE_URL_CREATE_REQUEST;
    }
}
