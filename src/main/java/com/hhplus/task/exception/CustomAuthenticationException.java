package com.hhplus.task.exception;

import javax.naming.AuthenticationException;

public class CustomAuthenticationException extends AuthenticationException {

    private String message = "";
    public CustomAuthenticationException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
