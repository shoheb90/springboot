package com.shbtechno.springboot.ui.userservice.impl;
/*
   @Author      : Shoheb
   Description  : Implementation class for user service interface
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @ Service     :   To map the class as service
   @      :   
   
 */

import com.shbtechno.springboot.ui.model.request.UserDetailsRequest;
import com.shbtechno.springboot.ui.model.response.UserRest;
import com.shbtechno.springboot.ui.userservice.UserService;
import com.shbtechno.springboot.ui.utilities.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    public Map<String,UserRest> users;
    Utils utils;
    //This is autowired for constructor based dependency injection
    @Autowired
    public UserServiceImpl(Utils utils){
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequest userDetailsRequest) {
        UserRest userRest = new UserRest();
        userRest.setFirstName(userDetailsRequest.getFirstName());
        userRest.setLastName(userDetailsRequest.getLastName());
        userRest.setEmail(userDetailsRequest.getEmail());
        userRest.setPassword(userDetailsRequest.getPassword());

        //Code to add value in map to store temporarily
        String userID = utils.getUserID();
        userRest.setUserID(userID);
        if (users==null) users = new HashMap<>();
        users.put(userID,userRest);
        return userRest;
    }
}
