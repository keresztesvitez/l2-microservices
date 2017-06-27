package com.epam.creditcard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentResponse {
    private double amount;
    private ResponseCustomer customer;
    private List<Integer> paymentTime;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(ResponseCustomer customer) {
        this.customer = customer;
    }

    public List<Integer> getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(List<Integer> paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "amount=" + amount +
                ", customer=" + customer +
                ", paymentTime=" + paymentTime +
                '}';
    }
}
