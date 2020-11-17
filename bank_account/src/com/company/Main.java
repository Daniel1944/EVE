package com.company;

import com.company.authentication.Login;
import com.company.authentication.Registration;
import com.company.authentication.SQLQueries;
import com.company.functionalities.BankFunction;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static int uniqueID;

    public static void main(String[] args) {
        System.out.println("Ahoj mas ucet v EVE? (Y/N)");
        String choice = sc.nextLine();
        choice = choice.toUpperCase();

        var bA = new BankFunction();
        var reg = new Registration();
        var log = new Login();
        var sql = new SQLQueries();


        boolean isRunning;
        do {
            if (choice.equals("N")) {
                reg.insertData();
                uniqueID = sql.getId();
                isRunning = false;
            } else if (choice.equals("Y")) {
                log.insertLogin();
                uniqueID = sql.getId();
                isRunning = false;
            } else {
                System.out.println("Zadal si neplatný znak. Zkus to znova )");
                isRunning = true;
            }
        } while (isRunning);

        String menu = ("Vyberte si funkci" + "\n" + "1) Vyber" + "\n" + "2) Vklad" + "\n" + "3) Tranfer" + "\n" + "4) Historie transakci" + "\n" + "5) Odhlasit se");
        System.out.println(menu);

        int choices;
        int amount;
        do {
            choices = sc.nextInt();
            switch (choices) {
                case 1 -> {
                    System.out.println("Kolik peneze si prejete vybrat?");
                    amount = sc.nextInt();
                    bA.withdraw(amount, "withdraw", "ATM withdraw");
                    //System.out.println("Vybral jste si: " + amount + "CZK." + "\n" + "Vas zustatek je: " + bA.balance + "CZK.");
                    System.out.println(menu);
                }
                case 2 -> {
                    System.out.println("Vlozte penize");
                    amount = sc.nextInt();
                    bA.deposit(amount, "deposit", "ATM deposit");
                   // System.out.println("Vlozil jste si na ucet: " + amount + "CZK." + "\n" + "Vas zustatek je: " + bA.balance + "CZK.");
                    System.out.println(menu);
                }
                case 3 -> {
                    System.out.println("Zadejte cislo uctu kam chcete prevest penize a jakou sumu chcete prevest.");
                    String accout = sc.nextLine();
                    amount = sc.nextInt();
                    //bA.transfer(amount, accout);
                   // System.out.println("Vlozil jste si na ucet: " + accout + " sumu" + amount + "CZK." + "\n" + "Vas zustatek je: " + bA.balance + "CZK.");
                    System.out.println(menu);
                }
                case 4 -> {
                    System.out.println("Zde je vase historie transakci: ");
                   // io.readFile(log.USERNAME + ".txt");
                    System.out.println(menu);
                }
            }
        } while (choices != 5);
    }


}
