package com.app.web.controlador;

public class DuplicatePatenteException extends RuntimeException {

    public DuplicatePatenteException(String message) {
        super(message);
    }
}