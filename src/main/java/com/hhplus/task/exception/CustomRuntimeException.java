package com.hhplus.task.exception;


public class CustomRuntimeException extends RuntimeException{

    private String message = "";
    public CustomRuntimeException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
