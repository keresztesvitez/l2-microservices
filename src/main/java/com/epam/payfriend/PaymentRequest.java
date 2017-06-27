package com.epam.payfriend;

import com.epam.Payment;

public class PaymentRequest {
    private PayFriend payFriend;
    private Payment payment;
    private PayFriend targetFriend;

    public PayFriend getPayFriend() {
        return payFriend;
    }

    public void setPayFriend(PayFriend payFriend) {
        this.payFriend = payFriend;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public PayFriend getTargetFriend() {
        return targetFriend;
    }

    public void setTargetFriend(PayFriend targetFriend) {
        this.targetFriend = targetFriend;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "payFriend=" + payFriend +
                ", payment=" + payment +
                ", targetFriend=" + targetFriend +
                '}';
    }
}
