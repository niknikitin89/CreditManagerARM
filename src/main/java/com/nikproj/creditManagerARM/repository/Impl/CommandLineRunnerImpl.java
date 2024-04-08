/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.repository.Impl;

import com.nikproj.creditManagerARM.model.entity.UserModel;
import com.nikproj.creditManagerARM.repository.UserDAOInterface;
import com.nikproj.creditManagerARM.util.HibernateSessionManager;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author user
 */
@Component
@AllArgsConstructor
public class CommandLineRunnerImpl implements CommandLineRunner {

    private UserDAOInterface userRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("!!!  CommandLineRunner started");

//        try {
//            ////Открываем сессию и начинаем транзакцию
//            Session session = HibernateSessionManager.openSession();
//            Transaction transaction = session.beginTransaction();
//
//            //Сохраняем пользователя
//            UserModel user = new UserModel();
//            user.setLastName("Nikitin");
//            user.setFirstName("Nikita");
//            userRepository.saveUser(user, session);
//            ////COMMIT
//            transaction.commit();
//        } catch (Exception e) {
//            System.out.println("Исключение!" + e);
//        }
    }

}
