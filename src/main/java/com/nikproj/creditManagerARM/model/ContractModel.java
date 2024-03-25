/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 *
 * @author user
 */
//@Data
@Entity
@Table(name = "contracts")
public class ContractModel {

    @Id
    @GeneratedValue
    private Long id;
//    private Long requestId;
    
    @OneToOne
    @JoinColumn(name = "request_id")
    private ApprovedRequestModel approveRequest;
    
    private Date contractDate;
    private String status;
    private Date signingDate;

    public enum Status {
        WAIT, SIGNED, CANCELED
    }

    public Long getId() {
        return id;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public String getStatus() {
        return status;
    }

    public Date getSigningDate() {
        return signingDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public void setStatus(Status status) {
        this.status = status.toString();
    }

    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }

    
    public ApprovedRequestModel getApproveRequest() {
        return approveRequest;
    }

    public void setApproveRequest(ApprovedRequestModel approveRequest) {
        this.approveRequest = approveRequest;
    }
}
