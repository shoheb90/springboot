package com.shbtechno.springboot.ui.controller;
/*
   @Author      : Shoheb
   Description  : User controller for all CRUD operations of GET,PUT,POST,DELETE
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import com.shbtechno.springboot.ui.exceptions.UserServiceException;
import com.shbtechno.springboot.ui.model.request.UpdateUserDetailsRequest;
import com.shbtechno.springboot.ui.model.request.UserDetailsRequest;
import com.shbtechno.springboot.ui.model.response.UserRest;
import com.shbtechno.springboot.ui.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users") //http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    //Temporary created map to store user details for PUT request
    Map<String,UserRest> users;

    //******************************************* GET *************************************************************
    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "30") int limit) {
        return "Get user was called with page " + page + "and limit : " + limit;
    }

    //Added Mediatype json and xml to return response in xml also if required
    @GetMapping(path = "/{userID}"
            ,produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userID) {
       // String firstname=null;
        //System.out.println(firstname.length());
        //Throwing own custom user exception
        //if (true) throw new UserServiceException("User service exception is thrown");

        if (users.containsKey(userID)){
            return new ResponseEntity<>(users.get(userID),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //******************************************* POST *************************************************************
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequest userDetailsRequest) {
         UserRest userRest = userService.createUser(userDetailsRequest);
        return new ResponseEntity<UserRest>(userRest,HttpStatus.CREATED);
    }


    //******************************************* PUT *************************************************************
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
                path = "/{userID}")
    public UserRest updateUser(@PathVariable String userID,@Valid @RequestBody UpdateUserDetailsRequest updateUserDetailsRequest) {
        UserRest storedUserDetails = users.get(userID);
        storedUserDetails.setFirstName(updateUserDetailsRequest.getFirstName());
        storedUserDetails.setLastName(updateUserDetailsRequest.getLastName());
        users.put(userID,storedUserDetails);
        return storedUserDetails;
    }


    //******************************************* DELETE *************************************************************
    @DeleteMapping(path = "/{userID}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userID) {
        users.remove(userID);
        return ResponseEntity.noContent().build();
    }


}
