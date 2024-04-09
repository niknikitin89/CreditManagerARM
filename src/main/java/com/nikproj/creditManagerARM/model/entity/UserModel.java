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
import java.util.Arrays;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author user
 */
@Entity
@Table(name = "users")
@Data
public class UserModel implements UserDetails{

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
    @Column(name = "jobtitle", length = 200)
    private String jobTitle;//должность
    private String username;
    private String password;
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
