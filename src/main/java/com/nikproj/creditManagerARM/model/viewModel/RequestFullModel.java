/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.model.viewModel;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author user
 */
@Data
@AllArgsConstructor
public class RequestFullModel {

    private Long id;
    private Long userId;
    private Date requestDate;
    private Double requestedSum;
    private String requestStatus;
    private Integer creditTerm;
    private Double approvedSum;

//    public RequestFullModel(Long id, Long userId, Date requestDate, Double requestedSum, String requestStatus, Integer creditTerm, Double approvedSum) {
//        this.id = id;
//        this.userId = userId;
//        this.requestDate = requestDate;
//        this.requestedSum = requestedSum;
//        this.requestStatus = requestStatus;
//        this.creditTerm = creditTerm;
//        this.approvedSum = approvedSum;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public Date getRequestDate() {
//        return requestDate;
//    }
//
//    public void setRequestDate(Date requestDate) {
//        this.requestDate = requestDate;
//    }
//
//    public Double getRequestedSum() {
//        return requestedSum;
//    }
//
//    public void setRequestedSum(Double requestedSum) {
//        this.requestedSum = requestedSum;
//    }
//
//    public String getRequestStatus() {
//        return requestStatus;
//    }
//
//    public void setRequestStatus(String requestStatus) {
//        this.requestStatus = requestStatus;
//    }
//
//    public Integer getCreditTerm() {
//        return creditTerm;
//    }
//
//    public void setCreditTerm(Integer creditTerm) {
//        this.creditTerm = creditTerm;
//    }
//
//    public Double getApprovedSum() {
//        return approvedSum;
//    }
//
//    public void setApprovedSum(Double approvedSum) {
//        this.approvedSum = approvedSum;
//    }

}
