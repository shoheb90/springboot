package com.shbtechno.springboot.ui.controller;
/*
   @Author      : Shoheb
   Description  : User controller for all CRUD operations of GET,PUT,POST,DELETE
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import com.shbtechno.springboot.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") //http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "30") int limit) {
        return "Get user was called with page " + page + "and limit : " + limit;
    }

    //Added Mediatype json and xml to return response in xml also if required
    @GetMapping(path = "/{userID}"
            ,produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userID) {
        UserRest userResponse = new UserRest();
        userResponse.setFirstName("Samrin");
        userResponse.setLastName("Inamdar");
        userResponse.setEmail("sss@gmail.com");
        return new ResponseEntity<UserRest> (userResponse,HttpStatus.OK);
    }

    @PostMapping
    public String createUser() {
        return "create user details";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user details";
    }

    @PutMapping
    public String updateUser() {
        return "update user details";
    }
}
