package com.company.functionalities;

import com.company.Constructors.User;
import com.company.authentication.Registration;
import com.company.authentication.SQLQueries;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankFunction {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    SQLQueries sqlQueries = new SQLQueries();

    User loginUser = sqlQueries.extractData();

    public double balance = loginUser.getBalance();
    int id = sqlQueries.getId();
    String date = "'" + dtf.format(now) + "'";

    public void monthRevenues() {
    }



    public void deposit(double amount, String type, String category) {
        type = "'" + type + "'";
        category = "'" + category + "'";
        String sql = "INSERT INTO account_activities (user_id, amount, type, date, category) VALUES (" + id + ", " + amount + ", " + type + ", " + date + ", " + category + ")";
        sqlQueries.bankFunction(sql);
        sqlQueries.updateBalance(balance + amount, id);
    }

    public void withdraw(double amount, String type, String category) {
        type = "'" + type + "'";
        category = "'" + category + "'";
        String sql = "INSERT INTO account_activities (user_id, amount, type, date, category) VALUES (" + id + ", " + amount + ", " + type + ", " + date + ", " + category + ")";
        sqlQueries.bankFunction(sql);
        sqlQueries.updateBalance(balance - amount, id);
    }

    public void transfer(int amount, String account, String type, String category) {
        if (account.length() == 16) {
            if (balance >= amount) {
                type = "'" + type + "'";
                category = "'" + category + "'";
                balance = balance - amount;
                String sql = "INSERT INTO account_activities (user_id, amount, type, date, category) VALUES (" + id + ", " + amount + ", " + type + ", " + date + ", " + category + ")";
                sqlQueries.updateBalance(balance - amount, id);
            }
        }
    }

    private void monthlySalary(int amount, String type, String category) {
        if (now.getDayOfMonth() == 9) {
        }
/**
 String encAccount(String accout) {
 String[] arr = accout.split("");
 for (int i = 0; i < arr.length - 4; i++) {
 arr[i] = "#";
 }
 accout = String.join("", arr);
 return accout;
 }
 */
    }
}
