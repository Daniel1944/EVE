package com.company.Constructors;

public class RegularPayments {
    public int id;
    public double amount;
    public String type;
    public int day;

    public RegularPayments(int id, double amount, String type, int day) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.day = day;
    }
}
