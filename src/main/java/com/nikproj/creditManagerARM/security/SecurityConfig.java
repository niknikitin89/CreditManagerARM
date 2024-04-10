/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.security;

import com.nikproj.creditManagerARM.model.Constants;
import com.nikproj.creditManagerARM.model.entity.UserModel;
import com.nikproj.creditManagerARM.repository.UserDAOInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author user
 */
@Configuration
public class SecurityConfig {

    /**
     * Создаем шифровальщик паролей
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        List<UserDetails> userList = new ArrayList<>();
//
//        userList.add(new User(
//                "nik", encoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//        userList.add(new User(
//                "someone", encoder.encode("password"),Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//        return new InMemoryUserDetailsManager(userList);
//        
//    }
    /**
     * Служба хранения учетных записей
     *
     * @param repository
     * @return
     */
    @Bean
    public UserDetailsService userDetailService(UserDAOInterface repository) {
        return username -> {
            UserModel user = repository.findByUsername(username);
            if (user != null) {
                return user;
            }

            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    /**
     * Настройка аутентификации при доступе по оперделенным URL
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain finterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        (request) -> {
                            request.requestMatchers(Constants.PAGE_URL_CREATE_REQUEST)
                                    .hasRole("USER");
                        }
                )//Задаем URL и описываем необходимые роли для доступа к нему
                //В данном случае нужна роль ROLE_USER
                .authorizeHttpRequests(
                        (request) -> {
                            request.requestMatchers("/**")
                                    .permitAll();
                        }//Всем остальным URL даем полный доступ
                )
                .build();
    }

}
