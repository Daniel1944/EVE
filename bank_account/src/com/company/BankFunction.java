package com.company;

import java.util.ArrayList;

class bank_function {
    int balance = 40000;
    //historie pohybu penez na ucte
    ArrayList<String> previousTransaction = new ArrayList<>();

    InputOutput io = new InputOutput();

    public final static String USERNAME = "Daniel1944";
    public final static String PASSWORD = "heslo";

    void deposit(int amount) {
        if (balance != 0) {
            balance = balance + amount;
            io.writeToFile(USERNAME + ".txt", "+" + String.valueOf(amount) + " Category: Deposit" + "\n");
        }
    }

    void withdraw(int amount) {
        if (balance != 0) {
            balance = balance - amount;
            io.writeToFile(USERNAME + ".txt", "\n" + "-" + String.valueOf(amount) + " Category: Withdraw");
        }
    }

    void transfer(int amount, String account) {
        if (account.length() == 16) {
            if (balance >= amount) {
                balance = balance - amount;
                io.writeToFile(USERNAME + ".txt", "\n" + "+" + String.valueOf(amount) + " Category: transfer to account(" + encAccount(account) + ")");
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

    boolean login(String name, String password) {
        boolean stmt = true;
        if (name.equals(USERNAME) & password.equals(PASSWORD)) {
            stmt = true;
        } else {
            stmt = false;
        }
        return stmt;
    }
}
