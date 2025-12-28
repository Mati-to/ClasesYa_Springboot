package com.backend.clasesya.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String mensaje) {
        super(mensaje);
    }

}
