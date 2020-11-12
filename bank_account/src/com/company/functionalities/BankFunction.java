package com.company.functionalities;

import com.company.authentication.Login;
import com.company.authentication.Registration;
import com.company.authentication.SQLQueries;

public class BankFunction {
    public int balance = 40000;

    Registration regName = new Registration();
    InputOutputFunction io = new InputOutputFunction();



    public void deposit(int amount) {
        if (balance != 0) {
            balance = balance + amount;
            //io.writeToFile(loginName.USERNAME + ".txt", "+" + amount + " Category: Deposit" + "\n");
        }
    }

    public void withdraw(int amount) {
        if (balance != 0) {
            balance = balance - amount;
            //io.writeToFile(loginName.USERNAME + ".txt", "\n" + "-" + amount + " Category: Withdraw");
        }
    }

    public void transfer(int amount, String account) {
        if (account.length() == 16) {
            if (balance >= amount) {
                balance = balance - amount;
              //  io.writeToFile(loginName.USERNAME + ".txt", "\n" + "+" + amount + " Category: transfer to account(" + encAccount(account) + ")");
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
