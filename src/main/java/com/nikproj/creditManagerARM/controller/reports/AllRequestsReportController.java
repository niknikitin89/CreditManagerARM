/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.controller.reports;

import com.nikproj.creditManagerARM.model.Constants;
import com.nikproj.creditManagerARM.model.viewModel.RequestFullModel;
import com.nikproj.creditManagerARM.service.reports.AllRequestsReportService;
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
@RequestMapping(Constants.PAGE_URL_REPORT_ALL_REQUESTS)
public class AllRequestsReportController {

    private final AllRequestsReportService service;

    @Autowired
    public AllRequestsReportController(AllRequestsReportService service) {
        this.service = service;
    }

    @ModelAttribute(name = "requests")
    public List<RequestFullModel> requests() {
        return new ArrayList<>();
    }

    @GetMapping
    public String showAllUsers(@ModelAttribute(name = "requests") List<RequestFullModel> requests) {
        service.fillRequestList(requests);
        return Constants.PAGE_NAME_ALL_REQUESTS;
    }

    @PostMapping(params = "home")
    public String onHomePage() {
        return "redirect:" + Constants.PAGE_URL_HOME;
    }
}
