/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.controller;

import com.nikproj.creditManagerARM.model.ContractViewForm;
import com.nikproj.creditManagerARM.model.RequestFormModel;
import com.nikproj.creditManagerARM.service.ContractBrowseService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author user
 */
@Controller
@SessionAttributes(names = {"request","contract"})
@RequestMapping("/cmarm/contract")
public class ContractBrowseController {

    private ContractBrowseService сontractBrowseService;

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

//        sessionStatus.setComplete();
        //Запрашиваем инфу по договору
        ContractViewForm contractInfo = сontractBrowseService.getContractInfo(request.getRequest().getId());
        ContractViewForm.copy(contractInfo, contractView);
        return "contract";

    }

    @PostMapping(params = "sign")
    public String signingContract(@ModelAttribute(name = "contract") ContractViewForm contractView,
            SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        сontractBrowseService.signContract(contractView.getId());
        return "redirect:/cmarm/create_credit_request";
    }

    @PostMapping(params = "cancel")
    public String cancelContract(@ModelAttribute(name = "contract") ContractViewForm contractView,
            SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        сontractBrowseService.cancelContract(contractView.getId());
        return "redirect:/cmarm/create_credit_request";
    }
}
