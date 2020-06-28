package com.shbtechno.springboot.paymentsSample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
   @Author: Shoheb 
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
    @RequestMapping("/payments/{paymentID}")
    public Payments getPayments(@PathVariable String paymentID){
        return paymentServices.getPayments(paymentID);
    }

    //POST REQUEST
    @RequestMapping(method = RequestMethod.POST,value = "/payments")
    public void addPayments(@RequestBody Payments payments){
        paymentServices.addPayment(payments);
    }

    //PUT REQUEST
    @RequestMapping(method = RequestMethod.PUT,value = "/payments/{paymentID}")
    public void updatePayments(@RequestBody  Payments payments,@PathVariable String paymentID){
        paymentServices.updatePayment(payments,paymentID);
    }

    //DELETE REQUEST
    @RequestMapping(method = RequestMethod.DELETE,value = "/payments/{paymentID}")
    public void deletePayments(@PathVariable  String paymentID){
        paymentServices.deletePayment(paymentID);
    }
}
