/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.controller.reports;

import com.nikproj.creditManagerARM.model.Constants;
import com.nikproj.creditManagerARM.model.viewModel.ContractReportViewForm;
import com.nikproj.creditManagerARM.service.reports.AllContractsReportService;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(Constants.PAGE_URL_REPORT_ALL_CONTRACTS)
public class AllContractsReportController {

    private final AllContractsReportService service;

    @Autowired
    public AllContractsReportController(AllContractsReportService service) {
        this.service = service;
    }

    @ModelAttribute(name = "contracts")
    public List<ContractReportViewForm> contracts() {
        return new ArrayList<>();
    }

    @GetMapping
    public String showAllUsers(
            @ModelAttribute(name = "contracts") List<ContractReportViewForm> contracts) {

        service.fillContractList(contracts);
        return Constants.PAGE_NAME_ALL_CONTRACTS;
    }

    @PostMapping(params = "home")
    public String onHomePage() {
        return "redirect:" + Constants.PAGE_URL_HOME;
    }
}
