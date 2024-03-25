/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.controller.reports;

import com.nikproj.creditManagerARM.model.UserModel;
import com.nikproj.creditManagerARM.model.UserSearchCriteria;
import com.nikproj.creditManagerARM.service.reports.UserSearchService;
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
@RequestMapping("/cmarm/user_search")
public class UserSearchController {

    private UserSearchService service;

    @Autowired
    public UserSearchController(UserSearchService service) {
        this.service = service;
    }

    @ModelAttribute(name = "users")
    public List<UserModel> users() {
        return new ArrayList<UserModel>();
    }

    @ModelAttribute(name = "search_criteria")
    public UserSearchCriteria searchCriteria() {
        return new UserSearchCriteria();
    }

    @GetMapping
    public String showSearchUsersPage(
            @ModelAttribute(name = "search_criteria") UserSearchCriteria searchCriteria,
            @ModelAttribute(name = "users") List<UserModel> users) {

//        if (!searchCriteria.isEmpty()) {
        service.searchUsers(searchCriteria, users);
//        }
        return "userList";
    }

    @PostMapping(params = "home")
    public String onHomePage() {
        return "redirect:/cmarm";
    }
}
