package com.shbtechno.springboot.ui.controller;
/*
   @Author      : Shoheb
   Description  : User controller for all CRUD operations of GET,PUT,POST,DELETE
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import com.shbtechno.springboot.ui.model.response.UserRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") //http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value = "limit", defaultValue = "30") int limit){
        return "Get user was called with page "+ page + "and limit : "+limit;
    }
    @GetMapping(path = "/{userID}")
    public UserRest getUser(@PathVariable String userID){

        UserRest userResponse = new UserRest();
        userResponse.setFirstName("Samrin");
        userResponse.setLastName("Inamdar");
        userResponse.setEmail("sss@gmail.com");
        return userResponse;
    }

    @PostMapping
    public String createUser(){
        return "create user details";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user details";
    }

    @PutMapping
    public String updateUser(){
        return "update user details";
    }
}
