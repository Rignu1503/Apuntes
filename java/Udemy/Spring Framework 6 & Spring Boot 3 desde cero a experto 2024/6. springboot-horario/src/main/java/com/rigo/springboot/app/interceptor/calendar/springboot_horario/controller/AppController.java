package com.rigo.springboot.app.interceptor.calendar.springboot_horario.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
public class AppController {

    @GetMapping("/foo")
    public ResponseEntity<?> foo(HttpServletRequest request){

        Map<String, Object> data = new HashMap<>();
        data.put("Title","Bienvenido al sistema de atencion");
        data.put("time",new Date());
        data.put("message", request.getAttribute("message"));

        return ResponseEntity.ok(data);
    }

}
