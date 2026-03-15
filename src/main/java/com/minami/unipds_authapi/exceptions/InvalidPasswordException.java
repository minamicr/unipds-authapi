package com.minami.unipds_authapi.exceptions;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String msg) {
        super(msg);
    }
}
