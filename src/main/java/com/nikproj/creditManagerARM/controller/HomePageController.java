/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/cmarm")
public class HomePageController {

    @GetMapping
    public String showHomePage() {
        return "homePage";
    }

    @PostMapping(params = "createRequest")
    public String onCreateRequestPage() {
        return "redirect:/cmarm/create_credit_request";
    }

    @PostMapping(params = "allUsers")
    public String onAllUsersPage() {
        return "redirect:/cmarm/all_users";
    }

    @PostMapping(params = "searchUser")
    public String onSearchUserPage() {
        return "redirect:/cmarm/user_search";
    }

    @PostMapping(params = "allRequests")
    public String onAllRequestPage() {
        return "redirect:/cmarm/all_requests";
    }

    @PostMapping(params = "allContracts")
    public String onAllContractsPage() {
        return "redirect:/cmarm/all_contracts";
    }
}
