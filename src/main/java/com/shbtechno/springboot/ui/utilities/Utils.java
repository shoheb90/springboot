package com.shbtechno.springboot.ui.utilities;
/*
   @Author      : Shoheb
   Description  : 
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class Utils {

    public String getUserID(){
        return UUID.randomUUID().toString();
    }
}
