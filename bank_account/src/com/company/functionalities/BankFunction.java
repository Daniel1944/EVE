package com.company.functionalities;

import com.company.authentication.Registration;
import com.company.authentication.SQLQueries;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankFunction {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    SQLQueries sqlQueries = new SQLQueries();

    SQLQueries.User loginUser = sqlQueries.extractData();

    double balance = loginUser.getBalance();
    int id = sqlQueries.getId();
    String date = "'" + dtf.format(now) + "'";

    public void deposit(double amount, String type, String category) {
        type = "'" + type + "'";
        category = "'" + category + "'";
        String sql = "INSERT INTO account_activities (user_id, amount, type, date, category) VALUES (" + id + ", " + amount + ", " + type + ", " + date + ", " + category + ")";
        sqlQueries.bankFunction(sql);

        sqlQueries.updateBalance(id, (amount + balance));
    }

    public void withdraw(double amount, String type, String category) {
        type = "'" + type + "'";
        category = "'" + category + "'";
        String sql = "INSERT INTO account_activities (user_id, amount, type, date, category) VALUES (" + id + ", " + amount + ", " + type + ", " + date + ", " + category + ")";
        sqlQueries.bankFunction(sql);

        sqlQueries.updateBalance(id, (balance - amount));
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
