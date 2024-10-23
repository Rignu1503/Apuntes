package com.rigo.springboot.di.error.springboot_error.controllers;

import com.rigo.springboot.di.error.springboot_error.exeptions.UserNotFoundExeption;
import com.rigo.springboot.di.error.springboot_error.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({ArithmeticException.class})

    /*
    * 1. -> creación de la clase Error
    * 2. -> creación de esta clase
    * */
    public ResponseEntity<Error> divisionZero(Exception e) {

        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error dividiendo");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());


//        return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> invalidNumber(Exception e) {

        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "Numero incorrecto");
        error.put("message", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;

    }

    @ExceptionHandler({NullPointerException.class,
            HttpMessageNotWritableException.class,
            UserNotFoundExeption.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundException(Exception e) {

        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "EL usuario o roll no existe");
        error.put("message", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;

    }




    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> noHandlerFound(NoHandlerFoundException e) {

        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api no encontrado");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
}
