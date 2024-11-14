package org.rigo.test.springboot.app.exceptions;

public class DIneroInsuficienteException extends RuntimeException {

    public DIneroInsuficienteException(String message) {
        super(message);
    }
}
