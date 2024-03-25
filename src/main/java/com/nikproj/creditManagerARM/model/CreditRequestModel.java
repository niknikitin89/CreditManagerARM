/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author user
 */
@Entity
@Table(name = "credit_request")
public class CreditRequestModel {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
    private Date requestDate; 
    private Double requestedSum;
    private String requestStatus;
    
    public enum Status{
        WAIT, APPROVED, REJECTED
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Double getRequestedSum() {
        return requestedSum;
    }

    public void setRequestedSum(Double requestedSum) {
        this.requestedSum = requestedSum;
    }

    public Status getRequestStatus() {
        return Enum.valueOf(Status.class, requestStatus);
    }

    public void setRequestStatus(Status requestStatus) {
        this.requestStatus = requestStatus.toString();
    }
    
    
}
