package com.company.authentication;

import com.company.functionalities.CryptoFunction;

import java.util.Scanner;

public class Login {

    static Scanner sc = new Scanner(System.in);
    SQLQueries sqlQueries = new SQLQueries();
    CryptoFunction.Caesar cs = new CryptoFunction.Caesar();

    SQLQueries.User loginUser = sqlQueries.extractData();

    public void insertLogin() {
        System.out.println("Vítej uřivateli zadej prosím své uživatelské jméno a heslo");
        boolean isRunning = true;

        do {
            System.out.println("Username:");
            String name = sc.next();
            System.out.println("Password: ");
            String password = sc.next();
            password = cs.encrypt(password);
            if (name.equals(loginUser.name) & password.equals(loginUser.password)) {
                isRunning = false;
            } else
                System.out.println("Udaje neodpovídají zkuste to znovu");
        } while (isRunning);

    }
}