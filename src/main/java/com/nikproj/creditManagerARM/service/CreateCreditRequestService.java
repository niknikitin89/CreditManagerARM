/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.service;

import com.nikproj.creditManagerARM.model.Constants;
import com.nikproj.creditManagerARM.model.entity.CreditRequestModel;
import com.nikproj.creditManagerARM.model.FamilyStatus;
import com.nikproj.creditManagerARM.model.viewModel.RequestFormModel;
import com.nikproj.creditManagerARM.model.entity.UserModel;
import com.nikproj.creditManagerARM.repository.CreditRequestDAOInterface;
import com.nikproj.creditManagerARM.repository.FamilyStatusesDAOInterface;
import com.nikproj.creditManagerARM.repository.UserDAOInterface;
import com.nikproj.creditManagerARM.util.HibernateSessionManager;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class CreateCreditRequestService {

    private final UserDAOInterface userDAO;
    private final FamilyStatusesDAOInterface familyStatusesDAO;
    private final CreditRequestDAOInterface creditRequestDAO;

    @Autowired
    public CreateCreditRequestService(
            UserDAOInterface userDAO,
            CreditRequestDAOInterface creditRequestDAO,
            FamilyStatusesDAOInterface familyStatusesDAO) {
        this.userDAO = userDAO;
        this.creditRequestDAO = creditRequestDAO;
        this.familyStatusesDAO = familyStatusesDAO;
    }

    public Long saveRequest(RequestFormModel model) {
        Long requestID = Long.valueOf(-1);

        try {
            ////Открываем сессию и начинаем транзакцию
            Session session = HibernateSessionManager.openSession();
            Transaction transaction = session.beginTransaction();

            //Сохраняем пользователя
            UserModel user = model.getUser();
            Long userID = saveUser(user, session);
            if (userID < 0) {
                System.err.println(Constants.ERR_SAVE_DATABASE);
                return Long.valueOf(-1);
            }

            //Сохраняем информацию по заявке
            ////Формируем заявку
            CreditRequestModel request = model.getRequest();
            request.setUser(user);
            request.setRequestDate(new Date());
            request.setRequestStatus(CreditRequestModel.Status.WAIT);

            ////Обновление
            requestID = creditRequestDAO.saveCreditRequest(request, session);
            if (requestID < 0) {
                System.err.println(Constants.ERR_SAVE_DATABASE);
                return Long.valueOf(-1);
            }

            ////COMMIT
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
        }

        return requestID;
    }

    private Long saveUser(UserModel user, Session session) {
        //Ищем существующего пользователя
        List<UserModel> usersFromDB = userDAO.findByFIOPassport(
                user.getFirstName(),
                user.getLastName(),
                user.getPatronymic(),
                user.getPassportSeria(),
                user.getPassportNumber());

        Long userID;
        if (usersFromDB == null || usersFromDB.isEmpty()) {
            //Создаем нового пользователя
            userID = userDAO.saveUser(user, session);
        } else {
            //Берем первого из списка
            user.setUserId(usersFromDB.get(0).getUserId());
            userID = user.getUserId();
        }

        return userID;
    }

    public List<FamilyStatus> getFamilyStatuses() {
        return familyStatusesDAO.getFamilyStatuses();
    }

}
