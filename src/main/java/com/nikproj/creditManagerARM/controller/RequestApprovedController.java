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
@RequestMapping("/cmarm/request_approved")
public class RequestApprovedController {

    @GetMapping
    public String showPage() {
        return "requestApproved";
    }

    @PostMapping(params = "home")
    public String onHomePage() {
        return "redirect:/cmarm";
    }

    @PostMapping(params = "createRequest")
    public String onCreateRequestPage() {
        return "redirect:/cmarm/create_credit_request";
    }
}
