/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.model.viewModel;

import java.util.Date;

/**
 *
 * @author user
 */
public class ContractViewForm {

    private Long id;
    private Long requestId;
    private Date contractDate;
    private Integer creditTerm;
    private Double approvedSum;

    private String firstName;
    private String lastName;
    private String patronymic;
    private Integer passportSeria;
    private Integer passportNumber;
    private String familyStatus;
    private String address;
    private String phone;

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

    public Integer getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(Integer creditTerm) {
        this.creditTerm = creditTerm;
    }

    public Double getApprovedSum() {
        return approvedSum;
    }

    public void setApprovedSum(Double approvedSum) {
        this.approvedSum = approvedSum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String secondName) {
        this.lastName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(Integer passportSeria) {
        this.passportSeria = passportSeria;
    }

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static void copy(ContractViewForm from, ContractViewForm to) {
        to.id = from.id;
        to.requestId = from.requestId;
        to.contractDate = from.contractDate;
        to.creditTerm = from.creditTerm;
        to.approvedSum = from.approvedSum;

        to.firstName = from.firstName;
        to.lastName = from.lastName;
        to.patronymic = from.patronymic;
        to.passportSeria = from.passportSeria;
        to.passportNumber = from.passportNumber;
        to.familyStatus = from.familyStatus;
        to.address = from.address;
        to.phone = from.phone;
    }
}
