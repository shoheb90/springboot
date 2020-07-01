package com.shbtechno.springboot.ui.exceptions;
/*
   @Author      : Shoheb
   Description  : Class to handle all exceptions
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import com.shbtechno.springboot.ui.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    //This method will automatically trigger when ANY exception occurs
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest webRequest){
        String errorMessageDesc = ex.getLocalizedMessage();
        if (errorMessageDesc == null) errorMessageDesc = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMessageDesc);

        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //This method is an example to handle specific exception of null pointer and multiple exception in single method
    @ExceptionHandler(value = {NullPointerException.class,UserServiceException.class})
    public ResponseEntity<Object> handleNullPointerException(Exception ex, WebRequest webRequest){
        String errorMessageDesc = ex.getLocalizedMessage();
        if (errorMessageDesc == null) errorMessageDesc = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMessageDesc);

        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //This method is an example to handle custom own exceptions
    /*@ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest webRequest){
        String errorMessageDesc = ex.getLocalizedMessage();
        if (errorMessageDesc == null) errorMessageDesc = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMessageDesc);

        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

}
