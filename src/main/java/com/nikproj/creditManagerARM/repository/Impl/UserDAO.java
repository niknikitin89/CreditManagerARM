/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.repository.Impl;

import com.nikproj.creditManagerARM.model.UserModel;
import com.nikproj.creditManagerARM.repository.UserDAOInterface;
import com.nikproj.creditManagerARM.utilit.HibernateSessionManager;
import io.micrometer.common.util.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Long id = (Long) session.save(model);
        return id;
    }

    @Override
    public UserModel findById(Long id) {
        try (Session session = HibernateSessionManager.openSession()) {
            return session.get(UserModel.class, id);
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
            return null;
        }
    }

    @Override
    public List<UserModel> getAllUsers() {
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
        try (Session session = HibernateSessionManager.openSession()) {

            Map<String, Object> parameterMap
                    = parametersToMap(firstName, lastName, patronymic, passportSeria, passportNumber, phone);

            String hql = createDinamicQuery(parameterMap);
            Query<UserModel> query = session.createQuery(hql);
            addSelectParameters(query, parameterMap);
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
    public List<UserModel> findByFIOPassport(String firstName, String lastName, String patronymic, Integer passportSeria, Integer passportNumber) {
        try (Session session = HibernateSessionManager.openSession()) {

            Map<String, Object> parameterMap
                    = parametersToMap(firstName, lastName, patronymic, passportSeria, passportNumber);

            String hql = createDinamicQuery(parameterMap);
            Query<UserModel> query = session.createQuery(hql);
            addSelectParameters(query, parameterMap);
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

    private Map<String, Object> parametersToMap(
            String firstName, String lastName, String patronymic,
            Integer passportSeria, Integer passportNumber) {

        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotEmpty(firstName)) {
            parameterMap.put("firstName", firstName);
        }
        if (StringUtils.isNotEmpty(lastName)) {
            parameterMap.put("lastName", lastName);
        }
        if (StringUtils.isNotEmpty(patronymic)) {
            parameterMap.put("patronymic", patronymic);
        }
        if (passportSeria != null && passportSeria != 0) {
            parameterMap.put("passportSeria", passportSeria);
        }
        if (passportNumber != null && passportNumber != 0) {
            parameterMap.put("passportNumber", passportNumber);
        }
        return parameterMap;
    }

    private Map<String, Object> parametersToMap(
            String firstName, String lastName, String patronymic,
            Integer passportSeria, Integer passportNumber, String phone) {

        Map<String, Object> parameterMap
                = parametersToMap(
                        firstName, lastName, patronymic,
                        passportSeria, passportNumber);

        if (StringUtils.isNotEmpty(phone)) {
            parameterMap.put("phone", phone);
        }
        return parameterMap;
    }

    private String createDinamicQuery(Map<String, Object> parameterMap) {
        StringBuilder selectBuilder = new StringBuilder();
        StringBuilder whereBuilder = new StringBuilder();

        //Откуда выбираем
        selectBuilder.append("from UserModel").append(System.lineSeparator());
        //Если условия не заданы будем выбирать все
        whereBuilder.append("where 1 = 1").append(System.lineSeparator());

        for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
            Object key = entry.getKey();
            whereBuilder.append("and " + key + " = :" + key)
                    .append(System.lineSeparator());
        }

        selectBuilder.append(whereBuilder);
        return selectBuilder.toString();
    }

    private void addSelectParameters(Query<UserModel> query, Map<String, Object> parameterMap) {
        for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            query.setParameter(key.toString(), value);
        }
    }

}
