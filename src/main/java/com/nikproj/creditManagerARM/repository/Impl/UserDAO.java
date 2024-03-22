/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.repository.Impl;

import com.nikproj.creditManagerARM.model.UserModel;
import com.nikproj.creditManagerARM.repository.UserDAOInterface;
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
public class UserDAO implements UserDAOInterface{

    @Override
    public Long saveUser(UserModel model) {
        SessionFactory sessionFactory = 
                HibernateSessionFactoryUtil.getSessionFactory();
        
        long id = 0;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();    
            id = (Long)session.save(model);
            System.out.println("Generated ID" + id);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
            id = -1;
        }
        
        return id;
    }

    @Override
    public UserModel findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
