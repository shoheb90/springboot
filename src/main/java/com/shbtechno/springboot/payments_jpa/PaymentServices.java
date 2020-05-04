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

    private List<Payments> payments = new ArrayList<>(Arrays.asList(
            new Payments("p1", "pending", "Inbound", (long) 9001),
            new Payments("p2", "initiated", "Outbound", (long) 9002),
            new Payments("p3", "completed", "Inbound", (long) 9003)
    ));

    public List<Payments> getAllPayments(){
        //return payments;
        List<Payments> payments = new ArrayList<>();
        /*  Findall is iterable and hence need to be added in list
            Used method ::add reference to iterate and add in the list
        */
        paymentsRepository.findAll().forEach(payments::add);
        return payments;
    }

    /* Optional class return types is used it handles null and is the return type for crudRepository findByID method */
    public Optional<Payments> getPayments(String paymentID){
       //return payments.stream().filter(p -> p.getPaymentID().equals(paymentID)).findFirst().get();
        return paymentsRepository.findById(paymentID);
    }

    //ADD METHOD FOR POST REQUEST
    public void addPayment(Payments pay) {
        //payments.add(pay);
        /*Crudrepository has save method to add objects*/
        paymentsRepository.save(pay);
    }

    //UPDATE METHOD FOR PUT REQUEST
    /* crudRepository.save works for both add and update */
    public void updatePayment(Payments pay, String paymentID) {
       paymentsRepository.save(pay);
        /*for (int i=0;i<payments.size();i++){
            Payments p = payments.get(i);
            if (p.getPaymentID().equals(paymentID)){
                payments.set(i,pay);
                return;
            }
        }*/
    }

    //DELETE METHOD
    public void deletePayment(String paymentID) {
//       payments.removeIf(p->p.getPaymentID().equals(paymentID));
        paymentsRepository.deleteById(paymentID);
    }
}
