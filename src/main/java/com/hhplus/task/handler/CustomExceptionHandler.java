package com.hhplus.task.handler;

import com.hhplus.task.exception.CustomRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * 에러 메시지를 반환한다.
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity<String> customRuntimeExceptionHandle(CustomRuntimeException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
