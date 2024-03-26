/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "approved_request")
public class ApprovedRequestModel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "request_id")
    private CreditRequestModel creditRequest;
    @Column(name = "creditterm")
    private Integer creditTerm;
    @Column(name = "approvedsum")
    private Double approvedSum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreditRequestModel getCreditRequest() {
        return creditRequest;
    }

    public void setCreditRequest(CreditRequestModel creditRequest) {
        this.creditRequest = creditRequest;
    }

    public Integer getCreditTerm() {
        return creditTerm;
    }

    public Double getApprovedSum() {
        return approvedSum;
    }

    public void setCreditTerm(Integer creditTerm) {
        this.creditTerm = creditTerm;
    }

    public void setApprovedSum(Double approvedSum) {
        this.approvedSum = approvedSum;
    }
    
}
