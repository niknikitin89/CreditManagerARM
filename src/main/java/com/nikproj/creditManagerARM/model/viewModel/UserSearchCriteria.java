/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.model.viewModel;

import lombok.Data;

/**
 *
 * @author user
 */
@Data
public class UserSearchCriteria {

    private String firstName = new String();
    private String lastName = new String();
    private String patronymic = new String();
    private String passportSeria = new String();
    private String passportNumber = new String();
    private String phone = new String();

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getPatronymic() {
//        return patronymic;
//    }
//
//    public void setPatronymic(String patronymic) {
//        this.patronymic = patronymic;
//    }
//
//    public String getPassportSeria() {
//        return passportSeria;
//    }
//
//    public void setPassportSeria(String passportSeria) {
//        this.passportSeria = passportSeria;
//    }
//
//    public String getPassportNumber() {
//        return passportNumber;
//    }
//
//    public void setPassportNumber(String passportNumber) {
//        this.passportNumber = passportNumber;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }

    public boolean isEmpty() {
        return this.firstName.isEmpty()
                && this.lastName.isEmpty()
                && this.patronymic.isEmpty()
                && this.passportSeria.isEmpty()
                && this.passportNumber.isEmpty()
                && this.phone.isEmpty();
    }

}
