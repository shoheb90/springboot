package com.shbtechno.springboot.ui.userservice;
/*
   @Author      : Shoheb
   Description  : Interface for user service
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import com.shbtechno.springboot.ui.model.request.UserDetailsRequest;
import com.shbtechno.springboot.ui.model.response.UserRest;

public interface UserService {

    UserRest createUser(UserDetailsRequest userDetailsRequest);
}
