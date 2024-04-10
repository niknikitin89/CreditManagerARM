/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikproj.creditManagerARM.controller;

import com.nikproj.creditManagerARM.model.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author user
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{

    /**
     * Конфигурируем нашу MVC
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //домашняя страница
        registry.addViewController("/").setViewName(Constants.PAGE_NAME_HOME);
        //страница авторизации
        registry.addViewController(Constants.PAGE_URL_LOGIN).setViewName(Constants.PAGE_NAME_LOGIN);
    }
}
