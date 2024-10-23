package com.rigo.springboot.di.error.springboot_error.controllers;

import com.rigo.springboot.di.error.springboot_error.exeptions.UserNotFoundExeption;
import com.rigo.springboot.di.error.springboot_error.models.domain.User;
import com.rigo.springboot.di.error.springboot_error.services.UserSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserSerive userService;

    @GetMapping
    public int index(){

//        int value 100/0;
        int value = Integer.parseInt("20x");
        return value;
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable("id") Long id) {
        User user = userService.findByUserByid(id).orElseThrow(() -> new UserNotFoundExeption("User not found"));

        System.out.println(user.getLastName());
        return user;
    }



}
