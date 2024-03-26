/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.repository.Impl;

import com.nikproj.creditManagerARM.model.FamilyStatus;
import com.nikproj.creditManagerARM.model.FamilyStatuses;
import com.nikproj.creditManagerARM.repository.FamilyStatusesDAOInterface;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class FamilyStatusesDAO implements FamilyStatusesDAOInterface {

    @Override
    public List<FamilyStatus> getFamilyStatuses() {
        //Здесь должно быть чтение из БД
        FamilyStatuses statuses = new FamilyStatuses();
        return statuses.getStatuses();
    }

}
