package com.rigo.springboot.di.error.springboot_error.exeptions;

public class UserNotFoundExeption extends RuntimeException {

    public UserNotFoundExeption(String message) {
        super(message);

    }

}
