package com.example.controller;

import com.example.exp.AppBadRequestException;
import com.example.exp.PhoneAlreadyExistExeption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler({AppBadRequestException.class, PhoneAlreadyExistExeption.class})
    public ResponseEntity<String> handleExeption(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

//Alohida yoziw

//    @ExceptionHandler(AppBadRequestException.class)
//    public ResponseEntity<String> handleExeption(AppBadRequestException e ){
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }

//    @ExceptionHandler(PhoneAlreadyExistExeption.class)
//    public ResponseEntity<String>handleExeption(PhoneAlreadyExistExeption e ){
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }
}
