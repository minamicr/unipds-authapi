package com.minami.unipds_authapi.exceptions;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException(String msg) {
        super(msg);
    }
}
