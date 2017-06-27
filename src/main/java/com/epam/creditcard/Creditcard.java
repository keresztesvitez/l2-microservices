package com.epam.creditcard;

public class Creditcard {
    private String creditCardNumber;
    private int cvc;
    private ExpirationDate expirationDate;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ExpirationDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Creditcard{" +
                "creditCardNumber='" + creditCardNumber + '\'' +
                ", cvc=" + cvc +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
