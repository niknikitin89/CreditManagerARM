/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.service.reports;

import com.nikproj.creditManagerARM.model.entity.UserModel;
import com.nikproj.creditManagerARM.repository.UserDAOInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class AllUsersReportService {

    private UserDAOInterface userDAO;

    @Autowired
    public AllUsersReportService(UserDAOInterface userDAO) {
        this.userDAO = userDAO;
    }

    public void fillUserList(List<UserModel> users) {
        //выбираем список всех пользователей   
        List<UserModel> usersFromDB = userDAO.getAllUsers();
        if (!usersFromDB.isEmpty()) {
            users.addAll(usersFromDB);
        }
    }

}
