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

/**
 *
 * @author user
 */
@Data
@Entity
@Table(name = "credit_request")
public class CreditRequestModel {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Date requestDate; 
    private Double requestedSum;
    private Status requestStatus;
    
    public enum Status{
        WAIT, APPROVED, REJECTED
    }
}
