package com.company.Constructors;

public class RegularPayments {
    public int id;
    public double amount;
    public String type;
    public String date;

    public RegularPayments(int id, double amount, String type, String date) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }
}
