package com.company;

import java.util.Scanner;

public class Login {

    static Scanner sc = new Scanner(System.in);
    SQLQueries sqlQueries = new SQLQueries();
    Crypto.Caesar cs = new Crypto.Caesar();

    String[] arr = sqlQueries.extractData();
    String name = cs.encrypt(arr[0]);

    public final String USERNAME = name;

    public void insertLogin() {
        System.out.println("Vítej uřivateli zadej prosím své uživatelské jméno a heslo");
        boolean isRunning = true;

        do {
            System.out.println("Username:");
            String name = sc.next();
            System.out.println("Password: ");
            String password = sc.next();
            password = cs.encrypt(password);
            arr = sqlQueries.extractData();
            if (name.equals(arr[0]) & password.equals(arr[2])) {
                isRunning = false;
            } else
                System.out.println("Udaje neodpovídají zkuste to znovu");
        } while (isRunning);

    }
}