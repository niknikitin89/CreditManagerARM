/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.controller.reports;

import com.nikproj.creditManagerARM.model.UserModel;
import com.nikproj.creditManagerARM.service.reports.AllUsersReportService;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/cmarm/all_users")
public class AllUsersReportController {
    
    private AllUsersReportService service;

    @Autowired
    public AllUsersReportController(AllUsersReportService service) {
        this.service = service;
    }
   
    @ModelAttribute(name = "users")
    public List<UserModel> users(){
        return new ArrayList<UserModel>();
    }
    
    @GetMapping
    public String showAllUsers(@ModelAttribute(name = "users") List<UserModel> users){
//        System.out.println(users.get(0).getLastName());
        service.fillUserList(users);
        return "allUsers";
    }
}
