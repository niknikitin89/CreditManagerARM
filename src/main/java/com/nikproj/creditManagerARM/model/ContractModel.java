/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author user
 */
@Data
@Entity
@Table(name = "contracts")
@NoArgsConstructor
public class ContractModel {
    
    @Id
    @GeneratedValue
    private Long id;
    private Long requestId;
    private Date contractDate;
    private Status status;
    private Date signingDate;
    
    public enum Status{
        WAIT, SIGNED, CANCELED
    }
}
