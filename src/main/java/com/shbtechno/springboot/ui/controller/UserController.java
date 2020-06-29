package com.shbtechno.springboot.ui.controller;
/*
   @Author      : Shoheb
   Description  : User controller for all CRUD operations of GET,PUT,POST,DELETE
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import com.shbtechno.springboot.ui.model.request.UpdateUserDetailsRequest;
import com.shbtechno.springboot.ui.model.request.UserDetailsRequest;
import com.shbtechno.springboot.ui.model.response.UserRest;
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
        /*UserRest userResponse = new UserRest();
        userResponse.setFirstName("Shoheb");
        userResponse.setLastName("Inamdar");
        userResponse.setEmail("sss@gmail.com");
*/
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
       UserRest userRest = new UserRest();
       userRest.setFirstName(userDetailsRequest.getFirstName());
       userRest.setLastName(userDetailsRequest.getLastName());
       userRest.setEmail(userDetailsRequest.getEmail());
       userRest.setPassword(userDetailsRequest.getPassword());

       //Code to add value in map to store temporarily
        String userID = UUID.randomUUID().toString();
        userRest.setUserID(userID);
        if (users==null) users = new HashMap<>();
        users.put(userID,userRest);
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
    @DeleteMapping
    public String deleteUser() {
        return "delete user details";
    }


}
