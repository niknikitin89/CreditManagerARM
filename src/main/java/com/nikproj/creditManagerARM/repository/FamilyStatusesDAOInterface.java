/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nikproj.creditManagerARM.repository;

import com.nikproj.creditManagerARM.model.FamilyStatus;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface FamilyStatusesDAOInterface {
    List<FamilyStatus> getFamilyStatuses();
}
