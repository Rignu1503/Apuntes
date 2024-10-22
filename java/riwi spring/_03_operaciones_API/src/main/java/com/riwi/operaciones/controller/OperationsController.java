package com.riwi.operaciones.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.operaciones.entities.Operations;

@RestController
@RequestMapping("/api/v1/operations")

public class OperationsController {

    @PostMapping(path = "/add")
    public String add(@RequestBody Operations objOperations) {

        String message = String.valueOf(objOperations.getNum1() + objOperations.getNum2());

        return objOperations.getNum1() + " + " + objOperations.getNum2() + " = " + message;
    }

    @PostMapping(path = "/subtract")
    public String subtract(@RequestBody Operations objOperations) {
        String message = String.valueOf(objOperations.getNum1() - objOperations.getNum2());

        return objOperations.getNum1() + " - " + objOperations.getNum2() + " = " + message;
    }

    @PostMapping(path = "/multiply")
    public String multiply(@RequestBody Operations objOperations) {
        String message = String.valueOf(objOperations.getNum1() * objOperations.getNum2());

        return objOperations.getNum1() + " * " + objOperations.getNum2() + " = " + message;
    }

    @PostMapping(path = "/divide")
    public String divide(@RequestBody Operations objOperations) {
        String message = String.valueOf(objOperations.getNum1() / objOperations.getNum2());

        //hola mundo?

        return objOperations.getNum1() + " / " + objOperations.getNum2() + " = " + message;
    }
    
}
