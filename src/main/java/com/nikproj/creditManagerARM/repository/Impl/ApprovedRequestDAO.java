/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.repository.Impl;

import com.nikproj.creditManagerARM.model.ApprovedRequestModel;
import com.nikproj.creditManagerARM.repository.ApprovedRequestDAOInterface;
import com.nikproj.creditManagerARM.utilit.HibernateSessionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class ApprovedRequestDAO implements ApprovedRequestDAOInterface {

    @Override
    public Long saveApprovedRequest(ApprovedRequestModel model, Session session) {
//        SessionFactory sessionFactory
//                = HibernateSessionManager.getSessionFactory();
//
//        long id = 0;
//        try (Session session = sessionFactory.openSession()) {
//            Transaction transaction = session.beginTransaction();
            Long id = (Long)session.save(model);
//            System.out.println("Generated ID" + id);
//            transaction.commit();
//        } catch (Exception e) {
//            System.out.println("Исключение!" + e);
//            id = -1;
//        }

        return id;
    }

    @Override
    public ApprovedRequestModel findById(Long id) {
//        SessionFactory sessionFactory
//                = HibernateSessionManager.getSessionFactory();

        try (Session session = HibernateSessionManager.openSession()) {
            return session.get(ApprovedRequestModel.class, id);
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
            return null;
        }
    }

}
