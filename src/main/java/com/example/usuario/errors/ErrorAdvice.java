package com.example.usuario.errors;

import com.example.usuario.exceptions.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFound (NotFoundException exception, HttpServletRequest request){
        return  ApiError.builder()
                                        .message(exception.getMessage())
                                        .status(HttpStatus.NOT_FOUND.value())
                                        .timestamp(LocalDateTime.now())
                                        .path(request.getServletPath())
                                        .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handle (MethodArgumentNotValidException exception, HttpServletRequest request){

        ApiError error = ApiError.builder()
                .status(400)
                .message(exception.getMessage())
                .path(request.getServletPath())
                .timestamp(LocalDateTime.now())
                .build();

        BindingResult bindingResult = exception.getBindingResult();
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError: bindingResult.getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        error.setValidationErrors(validationErrors);

        return error;
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError methodConstraintViolationException (SQLIntegrityConstraintViolationException exception,
                                                        HttpServletRequest request){

        ApiError error = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .path(request.getServletPath())
                .timestamp(LocalDateTime.now())
                .build();

        return error;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ApiError methodNotSupported (HttpRequestMethodNotSupportedException exception,
                                        HttpServletRequest request){

        ApiError error = ApiError.builder()
                .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                .message(exception.getMessage())
                .path(request.getServletPath())
                .timestamp(LocalDateTime.now())
                .build();

        return error;

    }

}
