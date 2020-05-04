package com.shbtechno.springboot.payments_jpa;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
   @Author: Shoheb 
*/
@Service
public class PaymentServices {

    private List<Payments> payments = new ArrayList<>(Arrays.asList(
            new Payments("p1", "pending", "Inbound", (long) 9001),
            new Payments("p2", "initiated", "Outbound", (long) 9002),
            new Payments("p3", "completed", "Inbound", (long) 9003)
    ));

    public List<Payments> getAllPayments(){
        return payments;
    }

    public Payments getPayments(String paymentID){
       return payments.stream().filter(p -> p.getPaymentID().equals(paymentID)).findFirst().get();
    }

    //ADD METHOD FOR POST REQUEST
    public void addPayment(Payments pay) {
        payments.add(pay);
    }

    //UPDATE METHOD FOR PUT REQUEST
    public void updatePayment(Payments pay, String paymentID) {
        for (int i=0;i<payments.size();i++){
            Payments p = payments.get(i);
            if (p.getPaymentID().equals(paymentID)){
                payments.set(i,pay);
                return;
            }
        }
    }

    //DELETE METHOD
    public void deletePayment(String paymentID) {
       payments.removeIf(p->p.getPaymentID().equals(paymentID));
    //payments.stream().filter(p -> p.getPaymentID().equals(paymentID)).findFirst().get();
    }
}
