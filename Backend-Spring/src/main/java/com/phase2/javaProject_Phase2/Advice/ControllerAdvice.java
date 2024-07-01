package com.phase2.javaProject_Phase2.Advice;


import com.phase2.javaProject_Phase2.exceptions.AdminExceptions.AdminSystemException;
import com.phase2.javaProject_Phase2.exceptions.CompanyExceptions.CompanySystemException;
import com.phase2.javaProject_Phase2.exceptions.CustomerExceptions.CustomerSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = {AdminSystemException.class, CompanySystemException.class, CustomerSystemException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDetails handlerError(Exception e){
        return new ErrDetails("Error", e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError)error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        System.out.println(exception.getBindingResult().getAllErrors());
        return errors;
    }
    @ExceptionHandler(value={Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDetails handleGeneralException(Exception e){
        //todo create exception for user errors....
        return new ErrDetails("Error",e.getMessage());
    }

}
