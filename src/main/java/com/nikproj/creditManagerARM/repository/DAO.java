/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.repository;

import com.nikproj.creditManagerARM.model.CreditRequestModel;
import com.nikproj.creditManagerARM.utilit.HibernateSessionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class DAO {

    public static void dosomething() {
        SessionFactory sessionFactory = 
                HibernateSessionManager.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Query<CreditRequestModel> query = 
                    session.createQuery("from CreditRequestModel", 
                            CreditRequestModel.class);
            query.toString();

        } catch (Exception e) {
            System.out.println("Исключение!" + e);
        }

    }
}
