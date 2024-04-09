/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.controller;

import com.nikproj.creditManagerARM.model.Constants;
import com.nikproj.creditManagerARM.model.viewModel.ContractViewForm;
import com.nikproj.creditManagerARM.model.viewModel.RequestFormModel;
import com.nikproj.creditManagerARM.service.ContractBrowseService;
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
@SessionAttributes(names = {"request","contract"})
@RequestMapping(Constants.PAGE_URL_CONTRACT)
public class ContractBrowseController {

    private final ContractBrowseService сontractBrowseService;

    @Autowired
    public ContractBrowseController(ContractBrowseService сontractBrowseService) {
        this.сontractBrowseService = сontractBrowseService;
    }

    @ModelAttribute(name = "contract")
    public ContractViewForm contract() {
        return new ContractViewForm();
    }

    @GetMapping
    public String showContract(
            @ModelAttribute(name = "request") RequestFormModel request,
            @ModelAttribute("contract") ContractViewForm contractView,
            SessionStatus sessionStatus) {

        //Запрашиваем инфу по договору
        ContractViewForm contractInfo = сontractBrowseService.getContractInfo(request.getRequest().getId());
        ContractViewForm.copy(contractInfo, contractView);
        
        return Constants.PAGE_NAME_CONTRACT;

    }

    @PostMapping(params = "sign")
    public String signingContract(@ModelAttribute(name = "contract") ContractViewForm contractView,
            SessionStatus sessionStatus) {
        
        sessionStatus.setComplete();
        сontractBrowseService.signContract(contractView.getId());
        
        return "redirect:" + Constants.PAGE_URL_CREATE_REQUEST;
    }

    @PostMapping(params = "cancel")
    public String cancelContract(@ModelAttribute(name = "contract") ContractViewForm contractView,
            SessionStatus sessionStatus) {
        
        sessionStatus.setComplete();
        сontractBrowseService.cancelContract(contractView.getId());
        
        return "redirect:"+ Constants.PAGE_URL_CREATE_REQUEST;
    }
}
