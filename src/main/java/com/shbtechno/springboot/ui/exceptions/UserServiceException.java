package com.shbtechno.springboot.ui.exceptions;
/*
   @Author      : Shoheb
   Description  :  Class to handle user defined custom exception
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

public class UserServiceException extends RuntimeException {

    public UserServiceException(String message){
        super(message);
    }
}
