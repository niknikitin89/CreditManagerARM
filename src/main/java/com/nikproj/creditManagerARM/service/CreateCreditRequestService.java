/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.service;

import com.nikproj.creditManagerARM.model.Constants;
import com.nikproj.creditManagerARM.model.CreditRequestModel;
import com.nikproj.creditManagerARM.model.RequestFormModel;
import com.nikproj.creditManagerARM.model.UserModel;
import com.nikproj.creditManagerARM.repository.CreditRequestDAOInterface;
import com.nikproj.creditManagerARM.repository.UserDAOInterface;
import com.nikproj.creditManagerARM.utilit.HibernateSessionManager;
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
    private final CreditRequestDAOInterface creditRequestDAO;

    @Autowired
    public CreateCreditRequestService(UserDAOInterface userDAO, CreditRequestDAOInterface creditRequestDAO) {
        this.userDAO = userDAO;
        this.creditRequestDAO = creditRequestDAO;
    }

    public Long saveRequest(RequestFormModel model) {
        Long requestID = Long.valueOf(-1);

////Открываем сессию и начинаем транзакцию
        try {
            Session session = HibernateSessionManager.openSession();
            Transaction transaction = session.beginTransaction();

            //Сохраняем пользователя
            UserModel user = model.getUser();
            Long userID = userDAO.saveUser(user, session);
            if (userID < 0) {
                System.err.println(Constants.ERR_SAVE_DATABASE);
                return Long.valueOf(-1);
            }

            //Сохраняем информацию по заявке
            ////Формируем заявку
            CreditRequestModel request = model.getRequest();
            request.setUser(user);
            request.setRequestStatus(CreditRequestModel.Status.WAIT);

            ////Обновление
            requestID = creditRequestDAO.saveCreditRequest(request, session);

            ////COMMIT
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
        }
        if (requestID < 0) {
            System.err.println(Constants.ERR_SAVE_DATABASE);
            return Long.valueOf(-1);
        }

        return requestID;
    }

}
