package com.example.vantasOtm.controller;

import com.example.vantasOtm.exception.BusinessException;
import com.example.vantasOtm.exception.RequestException;
import com.example.vantasOtm.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorModel> requestExceptionHandler(RequestException ex){
        ErrorModel error = ErrorModel.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorModel> businessExceptionHandler(BusinessException ex){
        ErrorModel error = ErrorModel.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }


}