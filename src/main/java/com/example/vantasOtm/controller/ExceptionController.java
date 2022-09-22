package com.example.vantasOtm.controller;

import com.example.vantasOtm.exception.RequestException;
import com.example.vantasOtm.model.ErrorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorModel> requestExceptionHandler(RequestException ex){
        ErrorModel error = ErrorModel.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }


}