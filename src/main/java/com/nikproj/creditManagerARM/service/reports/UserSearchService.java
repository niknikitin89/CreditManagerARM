/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.service.reports;

import com.nikproj.creditManagerARM.model.entity.UserModel;
import com.nikproj.creditManagerARM.model.viewModel.UserSearchCriteria;
import com.nikproj.creditManagerARM.repository.UserDAOInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class UserSearchService {

    private UserDAOInterface userDAO;

    @Autowired
    public UserSearchService(UserDAOInterface userDAO) {
        this.userDAO = userDAO;
    }

    public void searchUsers(UserSearchCriteria searchCriteria, List<UserModel> resultOfSearch) {

        Integer passportSeria;
        if (searchCriteria.getPassportSeria().isEmpty()) {
            passportSeria = 0;
        } else {
            passportSeria = Integer.valueOf(searchCriteria.getPassportSeria());
        }

        Integer passportNumber;
        if (searchCriteria.getPassportNumber().isEmpty()) {
            passportNumber = 0;
        } else {
            passportNumber = Integer.valueOf(searchCriteria.getPassportNumber());
        }

        List<UserModel> usersFromDB
                = userDAO.findByFIOPassportPhone(
                        searchCriteria.getFirstName(),
                        searchCriteria.getLastName(),
                        searchCriteria.getPatronymic(),
                        passportSeria,
                        passportNumber,
                        searchCriteria.getPhone());

        if (!usersFromDB.isEmpty()) {
            resultOfSearch.addAll(usersFromDB);
        }
    }

}
