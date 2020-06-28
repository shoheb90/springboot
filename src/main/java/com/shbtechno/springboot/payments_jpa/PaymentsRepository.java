package com.shbtechno.springboot.payments_jpa;
/*
   @Author      : Shoheb
   Description  : 
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   CrudRepository      : All common methods for CRUD operations
   @      :   
   
 */

import org.springframework.data.repository.CrudRepository;

public interface PaymentsRepository extends CrudRepository<Payments,String> {
}
