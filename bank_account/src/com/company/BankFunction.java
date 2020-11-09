package com.company;

import java.util.ArrayList;

class BankFunction {
    int balance = 40000;
    //historie pohybu penez na ucte
    ArrayList<String> previousTransaction = new ArrayList<>();
    Login loginName = new Login();

    InputOutput io = new InputOutput();


    void deposit(int amount) {
        if (balance != 0) {
            balance = balance + amount;
            io.writeToFile(loginName.USERNAME + ".txt", "+" + amount + " Category: Deposit" + "\n");
        }
    }

    void withdraw(int amount) {
        if (balance != 0) {
            balance = balance - amount;
            io.writeToFile(loginName.USERNAME + ".txt", "\n" + "-" + amount + " Category: Withdraw");
        }
    }

    void transfer(int amount, String account) {
        if (account.length() == 16) {
            if (balance >= amount) {
                balance = balance - amount;
                io.writeToFile(loginName.USERNAME + ".txt", "\n" + "+" + amount + " Category: transfer to account(" + encAccount(account) + ")");
            }
        }
    }

    String encAccount(String accout) {
        String[] arr = accout.split("");
        for (int i = 0; i < arr.length - 4; i++) {
            arr[i] = "#";
        }
        accout = String.join("", arr);
        return accout;
    }
}
