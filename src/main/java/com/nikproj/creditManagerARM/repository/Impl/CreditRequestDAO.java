/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.repository.Impl;

import com.nikproj.creditManagerARM.model.CreditRequestModel;
import com.nikproj.creditManagerARM.repository.CreditRequestDAOInterface;
import com.nikproj.creditManagerARM.utilit.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class CreditRequestDAO implements CreditRequestDAOInterface {

    @Override
    public Long saveCreditRequest(CreditRequestModel model) {
        SessionFactory sessionFactory
                = HibernateSessionFactoryUtil.getSessionFactory();

        long id = 0;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            id = (long) session.save(model);
            System.out.println("Generated ID" + id);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
            id = -1;
        }

        return id;
    }

    @Override
    public CreditRequestModel findById(Long id) {
        SessionFactory sessionFactory
                = HibernateSessionFactoryUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            return session.get(CreditRequestModel.class, id);
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
            return null;
        }
    }

    @Override
    public void updateCreditRequest(CreditRequestModel model) {
        SessionFactory sessionFactory
                = HibernateSessionFactoryUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(model);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
        }

    }

}
