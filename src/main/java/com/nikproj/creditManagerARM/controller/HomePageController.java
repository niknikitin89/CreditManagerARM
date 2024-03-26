/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.controller;

import com.nikproj.creditManagerARM.model.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(Constants.PAGE_URL_HOME)
public class HomePageController {

    @GetMapping
    public String showHomePage() {
        return Constants.PAGE_NAME_HOME;
    }

    @PostMapping(params = "createRequest")
    public String onCreateRequestPage() {
        return "redirect:" + Constants.PAGE_URL_CREATE_REQUEST;
    }

    @PostMapping(params = "allUsers")
    public String onAllUsersPage() {
        return "redirect:" + Constants.PAGE_URL_REPORT_ALL_USERS;
    }

    @PostMapping(params = "searchUser")
    public String onSearchUserPage() {
        return "redirect:" + Constants.PAGE_URL_SEARCH_USER;
    }

    @PostMapping(params = "allRequests")
    public String onAllRequestPage() {
        return "redirect:" + Constants.PAGE_URL_REPORT_ALL_REQUESTS;
    }

    @PostMapping(params = "allContracts")
    public String onAllContractsPage() {
        return "redirect:" + Constants.PAGE_URL_REPORT_ALL_CONTRACTS;
    }
}
