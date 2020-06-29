package com.shbtechno.springboot.ui.model.request;
/*
   @Author      : Shoheb
   Description  : 
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequest {
    @NotNull(message = "FirstName should not be null")
    @Size(min = 2,message = "Firstname should be more than 2 characters")
    private String firstName;

    @NotNull(message = "LastName should not be null")
    private String lastName;

    @NotNull(message = "Email should not be null")
    @Email
    private String email;

    @NotNull(message = "Password should not be null")
    @Size(min = 6,max = 16,message = "Password size should be greater than 6 and less than 16 characters")
    private String password;

    private String UserID;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
