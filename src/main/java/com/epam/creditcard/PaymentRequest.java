package com.epam.creditcard;

import com.epam.Payment;

public class PaymentRequest {
    private Creditcard creditcard;
    private Customer customer;
    private Payment payment;

    public Creditcard getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(Creditcard creditcard) {
        this.creditcard = creditcard;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "creditcard=" + creditcard +
                ", customer=" + customer +
                ", payment=" + payment +
                '}';
    }
}
