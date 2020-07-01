package com.shbtechno.springboot.ui.model.response;
/*
   @Author      : Shoheb
   Description  : To Customize the exception error message
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import java.util.Date;

public class ErrorMessage {
    private Date timestamp;
    private String errorMessage;

    public ErrorMessage(Date timestamp, String errorMessage) {
        this.timestamp = timestamp;
        this.errorMessage = errorMessage;
    }

    public ErrorMessage(){

    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
