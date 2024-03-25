/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.repository.Impl;

import com.nikproj.creditManagerARM.model.UserModel;
import com.nikproj.creditManagerARM.repository.UserDAOInterface;
import com.nikproj.creditManagerARM.utilit.HibernateSessionManager;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class UserDAO implements UserDAOInterface {

    @Override
    public Long saveUser(UserModel model, Session session) {
//        SessionFactory sessionFactory
//                = HibernateSessionManager.getSessionFactory();
//
//        long id = 0;
//        try (Session session = sessionFactory.openSession()) {
//            Transaction transaction = session.beginTransaction();
            Long id = (Long) session.save(model);
//            System.out.println("Generated ID" + id);
//            transaction.commit();
//        } catch (Exception e) {
//            System.out.println("Исключение!" + e);
//            id = -1;
//        }

        return id;
    }

    @Override
    public UserModel findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UserModel> getAllUsers() {
//        SessionFactory sessionFactory
//                = HibernateSessionManager.getSessionFactory();

        try (Session session = HibernateSessionManager.openSession()) {

            String hql = "from UserModel";
            Query<UserModel> query = session.createQuery(hql);
            List<UserModel> list = query.list();
            if (list.isEmpty()) {
                return null;
            }

            return list;
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
            return null;
        }

    }

    @Override
    public List<UserModel> findByFIOPassportPhone(String firstName, String lastName, String patronymic, Integer passportSeria, Integer passportNumber, String phone) {
//        SessionFactory sessionFactory
//                = HibernateSessionManager.getSessionFactory();

        try (Session session = HibernateSessionManager.openSession()) {

            String hql = createDinamicQuery(firstName, lastName, patronymic, passportSeria, passportNumber, phone);
            Query<UserModel> query = session.createQuery(hql);
            addSelectParameters(query, firstName, lastName, patronymic, passportSeria, passportNumber, phone);
            List<UserModel> list = query.list();
            if (list.isEmpty()) {
                return null;
            }

            return list;
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
            return null;
        }
    }

    private String createDinamicQuery(String firstName, String lastName, String patronymic, Integer passportSeria, Integer passportNumber, String phone) {
        StringBuilder selectBuilder = new StringBuilder();
        StringBuilder whereBuilder = new StringBuilder();

        selectBuilder.append("from UserModel").append(System.lineSeparator());
        //Если условия не заданы будем выбирать все
        whereBuilder.append("where 1 = 1").append(System.lineSeparator());

        if (StringUtils.isNotEmpty(firstName)) {
            whereBuilder
                    .append("and firstName = :firstName")
                    .append(System.lineSeparator());
        }
        if (StringUtils.isNotEmpty(lastName)) {
            whereBuilder
                    .append("and lastName = :lastName")
                    .append(System.lineSeparator());
        }
        if (StringUtils.isNotEmpty(patronymic)) {
            whereBuilder
                    .append("and patronymic = :patronymic")
                    .append(System.lineSeparator());
        }
        if (passportSeria != 0) {
            whereBuilder
                    .append("and passportSeria = :passportSeria")
                    .append(System.lineSeparator());
        }
        if (passportNumber != 0) {
            whereBuilder
                    .append("and passportNumber = :passportNumber")
                    .append(System.lineSeparator());
        }
        if (StringUtils.isNotEmpty(phone)) {
            whereBuilder
                    .append("and phone = :phone")
                    .append(System.lineSeparator());
        }

        selectBuilder.append(whereBuilder);

        return selectBuilder.toString();
    }

    private void addSelectParameters(Query<UserModel> query, String firstName, String lastName, String patronymic, Integer passportSeria, Integer passportNumber, String phone) {
        if (StringUtils.isNotEmpty(firstName)) {
            query.setParameter("firstName", firstName);
        }
        if (StringUtils.isNotEmpty(lastName)) {
            query.setParameter("lastName", lastName);
        }
        if (StringUtils.isNotEmpty(patronymic)) {
            query.setParameter("patronymic", patronymic);
        }
        if (passportSeria != 0) {
            query.setParameter("passportSeria", passportSeria);
        }
        if (passportNumber != 0) {
            query.setParameter("passportNumber", passportNumber);
        }
        if (StringUtils.isNotEmpty(phone)) {
            query.setParameter("phone", phone);
        }
    }

}
