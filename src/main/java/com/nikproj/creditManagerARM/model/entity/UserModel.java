/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userId;

    @Column(name = "firstname", length = 30)
    private String firstName;//имя
    @Column(name = "lastname", length = 30)
    private String lastName;//фамилия
    @Column(name = "patronymic", length = 30)
    private String patronymic;//отчество

    @Column(name = "passportseria")
    private Integer passportSeria;//серия паспорта
    @Column(name = "passportnumber")
    private Integer passportNumber;//номер паспорта

    @Column(name = "familystatus", length = 10)
    private String familyStatus;//семейное положение
    @Column(name = "address", length = 100)
    private String address;//адрес прописки
    @Column(name = "phone", length = 11)
    private String phone;//телефон

    @Column(name = "lastworkplace", length = 200)
    private String lastWorkPlace;//последнее место работы
    @Column(name = "workperiod")
    private Integer workPeriod;//период работы
    @Column(name = "jobtitile", length = 200)
    private String jobTitile;//должность

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getLastWorkPlace() {
        return lastWorkPlace;
    }

    public void setLastWorkPlace(String lastWorkPlace) {
        this.lastWorkPlace = lastWorkPlace;
    }

    public Integer getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Integer workPeriod) {
        this.workPeriod = workPeriod;
    }

    public String getJobTitile() {
        return jobTitile;
    }

    public void setJobTitile(String jobTitile) {
        this.jobTitile = jobTitile;
    }

}
