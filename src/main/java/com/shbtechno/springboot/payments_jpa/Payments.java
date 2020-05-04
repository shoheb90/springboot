package com.shbtechno.springboot.payments_jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
   @Author      : Shoheb
   Description  :    DTO method to store payment details
   Annotations  :
   @Entity      :   Identifies this as database entity class, class name as table name
                    and all member variables should be treated as columns of the database
   @Id          :   Field level annotation to tell the field is primary key in relational
                    database table
*/
@Entity
public class Payments {

    @Id
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
