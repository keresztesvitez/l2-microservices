package com.epam.creditcard;

import java.util.List;

public class ResponseCustomer extends Customer {

    private List<Integer> dateOfBirth;

    @Override
    public String getDateOfBirth() {
        return dateOfBirth.toString();
    }

    public void setDateOfBirth(List<Integer> dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
