package com.shbtechno.springboot.ui.model.request;
/*
   @Author      : Shoheb
   Description  : 
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import javax.validation.constraints.NotNull;

public class UpdateUserDetailsRequest {

    @NotNull(message = "first name cannot be null")
    private String firstName;
    @NotNull(message = "last name cannot be null")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
