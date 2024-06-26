/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.repository.Impl;

import com.nikproj.creditManagerARM.model.entity.CreditRequestModel;
import com.nikproj.creditManagerARM.model.viewModel.RequestFullModel;
import com.nikproj.creditManagerARM.repository.CreditRequestDAOInterface;
import com.nikproj.creditManagerARM.util.HibernateSessionManager;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class CreditRequestDAO implements CreditRequestDAOInterface {

    @Override
    public Long saveCreditRequest(CreditRequestModel model, Session session) {
        long id = (long) session.save(model);
        return id;
    }

    @Override
    public CreditRequestModel findById(Long id) {
        try (Session session = HibernateSessionManager.openSession()) {
            return session.get(CreditRequestModel.class, id);
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
            return null;
        }
    }

    @Override
    public void updateCreditRequest(CreditRequestModel model, Session session) {
        session.update(model);
    }

    @Override
    public List<RequestFullModel> getFullRequestInfo() {
        try (Session session = HibernateSessionManager.openSession()) {

            String hql
                    = "select new com.nikproj.creditManagerARM.model.viewModel.RequestFullModel("
                    + "r.id, r.user.userId, r.requestDate, r.requestedSum, r.requestStatus, "
                    + "a.creditTerm, a.approvedSum) "
                    + "from CreditRequestModel r "
                    + "left join ApprovedRequestModel a "
                    + "on r.id = a.creditRequest.id "
                    + "order by r.id asc";

            Query<RequestFullModel> query = session.createQuery(hql);
            List<RequestFullModel> list = query.list();
            return list;
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
            return new ArrayList<>();
        }
    }

}
