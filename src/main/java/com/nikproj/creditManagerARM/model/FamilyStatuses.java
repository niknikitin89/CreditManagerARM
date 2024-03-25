/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nikproj.creditManagerARM.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class FamilyStatuses {

    private Map<String,FamilyStatus> statuses;

    public FamilyStatuses() {
        statuses = new HashMap<>();
        statuses.put("MARRIED",new FamilyStatus("MARRIED", "Женат/Замужем"));
        statuses.put("FREE", new FamilyStatus("FREE", "Холост/Не замужем"));
    }

    public List<FamilyStatus> getStatuses() {
        return new ArrayList<>(statuses.values());
    }

    public void setStatuses(Map<String,FamilyStatus> statuses) {
        this.statuses = statuses;
    }
    
 
}
