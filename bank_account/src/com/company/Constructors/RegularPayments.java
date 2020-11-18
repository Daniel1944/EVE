package com.company.Constructors;

public class RegularPayments {
    public int id;
    public String type;
    public double amount;
    public String date;

    public RegularPayments(int id,String type, double amount, String date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }
}
