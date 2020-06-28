package com.shbtechno.springboot.paymentsSample;

/*
   @Author: Shoheb
   DTO method to store payment details
*/
public class Payments {
    private  String paymentID;
    private  String status;
    private  String direction;
    private  Long amount;

    public Payments() {
    }

    public Payments(String paymentID, String status, String direction, Long amount) {
        super();
        this.paymentID = paymentID;
        this.status = status;
        this.direction = direction;
        this.amount = amount;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
