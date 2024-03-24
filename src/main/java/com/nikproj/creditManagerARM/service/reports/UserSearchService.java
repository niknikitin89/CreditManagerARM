/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.service.reports;

import com.nikproj.creditManagerARM.model.UserModel;
import com.nikproj.creditManagerARM.model.UserSearchCriteria;
import com.nikproj.creditManagerARM.repository.Impl.UserDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class UserSearchService {

    private UserDAO userDAO;

    @Autowired
    public UserSearchService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void searchUsers(UserSearchCriteria searchCriteria, List<UserModel> resultOfSearch) {
        List<UserModel> usersFromDB = userDAO.findByFIOPassportPhone(
                searchCriteria.getFirstName(),
                searchCriteria.getLastName(),
                searchCriteria.getPatronymic(),
                searchCriteria.getPassportSeria(),
                searchCriteria.getPassportNumber(),
                searchCriteria.getPhone());

        if (!usersFromDB.isEmpty()) {
            resultOfSearch.addAll(usersFromDB);
        }
    }

}
