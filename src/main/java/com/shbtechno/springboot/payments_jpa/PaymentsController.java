package com.shbtechno.springboot.payments_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
   @Author      : Shoheb
   Description  :
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>
   @RestController  : Mark class as request handler and used to create RESTful webservices
   @Autowired       : Get the instant of the bean/ Initialise the variable
   @RequestMapping  : Map web service requests

*/
@RestController
public class PaymentsController {

    @Autowired
    private PaymentServices paymentServices;

    @RequestMapping("/payments")
    public List<Payments> getAllPayments() {
        return paymentServices.getAllPayments();
    }

    //GET REQUEST WITH PARAMETER
    /* Optional class return types is used it handles null and is the return type for crudRepository findByID method */
    @RequestMapping("/payments/{paymentID}")
    public Optional<Payments> getPayments(@PathVariable String paymentID){
        return paymentServices.getPayments(paymentID);
    }

    //POST REQUEST
    @RequestMapping(method = RequestMethod.POST,value = "/payments")
    public void addPayments(@RequestBody Payments payments){
        paymentServices.addPayment(payments);
    }

    //PUT REQUEST
    @RequestMapping(method = RequestMethod.PUT,value = "/payments/{paymentID}")
    public void updatePayments(@RequestBody Payments payments, @PathVariable String paymentID){
        paymentServices.updatePayment(payments,paymentID);
    }

    //DELETE REQUEST
    @RequestMapping(method = RequestMethod.DELETE,value = "/payments/{paymentID}")
    public void deletePayments(@PathVariable  String paymentID){
        paymentServices.deletePayment(paymentID);
    }
}
