/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.model;

/**
 *
 * @author user
 */
public class UserSearchCriteria {

    private String firstName = new String();
    private String lastName = new String();
    private String patronymic = new String();
    private Integer passportSeria = 0;
    private Integer passportNumber = 0;
    private String phone = new String();

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEmpty() {
        if (this.firstName.isEmpty()
                && this.lastName.isEmpty()
                && this.patronymic.isEmpty()
                && this.passportSeria == 0
                && this.passportNumber == 0
                && this.phone.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
