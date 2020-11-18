package com.company.Constructors;

public class User {

    public String name;
    public String email;
    public String password;
    public String role;
    public double balance;

    public User(String name, String email, String password, String role, double balance) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

}
