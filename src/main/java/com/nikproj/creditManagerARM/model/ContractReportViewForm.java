/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.model;

import java.util.Date;

/**
 *
 * @author user
 */
public class ContractReportViewForm {

    private Long id;
    private Long requestId;
    private Date contractDate;
    private String status;
    private Date signingDate;

    public ContractReportViewForm(Long id, Long requestId, Date contractDate, String status, Date signingDate) {
        this.id = id;
        this.requestId = requestId;
        this.contractDate = contractDate;
        this.status = status;
        this.signingDate = signingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }
    
   
}
