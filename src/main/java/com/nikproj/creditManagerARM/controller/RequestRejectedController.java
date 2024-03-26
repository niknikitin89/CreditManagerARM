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
@RequestMapping(Constants.PAGE_URL_REQUEST_REJECTED)
public class RequestRejectedController {

    @GetMapping
    public String showPage() {
        return Constants.PAGE_NAME_REQUEST_REJECTED;
    }

    @PostMapping(params = "home")
    public String onHomePage() {
        return "redirect:" + Constants.PAGE_URL_HOME;
    }

    @PostMapping(params = "createRequest")
    public String onCreateRequestPage() {
        return "redirect:" + Constants.PAGE_URL_CREATE_REQUEST;
    }
}
