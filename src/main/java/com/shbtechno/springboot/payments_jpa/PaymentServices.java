package com.shbtechno.springboot.payments_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
   @Author      : Shoheb
   Description  :
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>
   @Service      : Marks this class as a service class
   @      :

*/
@Service
public class PaymentServices {

    @Autowired
    private PaymentsRepository paymentsRepository;

    public List<Payments> getAllPayments(){
        List<Payments> payments = new ArrayList<>();
        /*  Findall is iterable and hence need to be added in list
            Used method ::add reference to iterate and add in the list
        */
        paymentsRepository.findAll().forEach(payments::add);
        return payments;
    }

    /* Optional class return types is used it handles null and is the return type for crudRepository findByID method */
    public Optional<Payments> getPayments(String paymentID){
        return paymentsRepository.findById(paymentID);
    }

    //ADD METHOD FOR POST REQUEST
    public void addPayment(Payments pay) {
        /*Crudrepository has save method to add objects*/
        paymentsRepository.save(pay);
    }

    //UPDATE METHOD FOR PUT REQUEST
    /* crudRepository.save works for both add and update */
    public void updatePayment(Payments pay, String paymentID) {
       paymentsRepository.save(pay);
    }

    //DELETE METHOD
    public void deletePayment(String paymentID) {
        paymentsRepository.deleteById(paymentID);
    }
}
