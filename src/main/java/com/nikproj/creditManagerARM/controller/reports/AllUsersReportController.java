/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.controller.reports;

import com.nikproj.creditManagerARM.model.Constants;
import com.nikproj.creditManagerARM.model.entity.UserModel;
import com.nikproj.creditManagerARM.service.reports.AllUsersReportService;
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
@RequestMapping(Constants.PAGE_URL_REPORT_ALL_USERS)
public class AllUsersReportController {

    private final AllUsersReportService service;

    @Autowired
    public AllUsersReportController(AllUsersReportService service) {
        this.service = service;
    }

    @ModelAttribute(name = "users")
    public List<UserModel> users() {
        return new ArrayList<>();
    }

    @GetMapping
    public String showAllUsers(@ModelAttribute(name = "users") List<UserModel> users) {
        service.fillUserList(users);
        return Constants.PAGE_NAME_ALL_USERS;
    }

    @PostMapping(params = "home")
    public String onHomePage() {
        return "redirect:" + Constants.PAGE_URL_HOME;
    }
}
