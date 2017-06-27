package com.epam.payfriend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentResponse {
    private double amount;
    private PayFriend payFriend;
    private PayFriend targetFriend;
    private List<Integer> paymentTime;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PayFriend getPayFriend() {
        return payFriend;
    }

    public void setPayFriend(PayFriend payFriend) {
        this.payFriend = payFriend;
    }

    public PayFriend getTargetFriend() {
        return targetFriend;
    }

    public void setTargetFriend(PayFriend targetFriend) {
        this.targetFriend = targetFriend;
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
                ", payFriend=" + payFriend +
                ", targetFriend=" + targetFriend +
                ", paymentTime=" + paymentTime +
                '}';
    }
}
