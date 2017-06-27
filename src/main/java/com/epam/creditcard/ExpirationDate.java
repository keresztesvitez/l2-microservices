package com.epam.creditcard;

public class ExpirationDate {
    private int month;
    private int year;

    public ExpirationDate() {}

    public ExpirationDate( int year, int month) {
        this.year = year;
        this. month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ExpirationDate{" +
                "month=" + month +
                ", year=" + year +
                '}';
    }
}
