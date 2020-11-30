package com.company;

import com.company.Constructors.RegularPayments;
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
                log.insertLogin();
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

        String menu = ("Vyberte si funkci" + "\n" + "1) Vyber" + "\n" + "2) Vklad" + "\n" + "3) Tranfer" + "\n" + "4) Historie transakci" + "\n" + "5) Pridat mesicni akce" + "\n" + "6) Odhlasit se");
        System.out.println(menu);

        int choices;
        double amount;
        do {
            choices = sc.nextInt();
            switch (choices) {
                case 1 -> {
                    System.out.println("Kolik peneze si prejete vybrat?");
                    amount = sc.nextDouble();
                    bA.withdraw(amount, "withdraw", "ATM withdraw");
                    System.out.println("Vybral jste si: " + amount + "CZK." + "\n" + "Vas zustatek je: " + bA.balance + "CZK.");
                    System.out.println(menu);
                }
                case 2 -> {
                    System.out.println("Vlozte penize");
                    amount = sc.nextDouble();
                    bA.deposit(amount, "deposit", "ATM deposit");
                    System.out.println("Vlozil jste si na ucet: " + amount + "CZK." + "\n" + "Vas zustatek je: " + bA.balance + "CZK.");
                    System.out.println(menu);
                }
                case 3 -> {
                    System.out.println("Zadejte cislo uctu kam chcete prevest penize a jakou sumu chcete prevest.");
                    String account = sc.next();
                    amount = sc.nextDouble();
                    bA.transfer(amount, account, "money transfer", ("Transfer to account +" + account));
                    System.out.println("Vlozil jste si na ucet: " + account + " sumu" + amount + "CZK." + "\n" + "Vas zustatek je: " + bA.balance + "CZK.");
                    System.out.println(menu);
                }
                case 4 -> {
                    System.out.println("Zde je vase historie transakci: ");
                   // io.readFile(log.USERNAME + ".txt");
                    System.out.println(menu);
                }
                case 5 -> {
                    System.out.println("Pridejte vase mesicni platby/prijmi");
                    System.out.println("Zadejte sumu");
                    amount = sc.nextDouble();
                    System.out.println("Zadejte o jakou platbu se jedná.");
                    String type = sc.nextLine();
                    System.out.println("Zadejte den splatnosti.");
                    int day = sc.nextInt();
                    RegularPayments regularPayments = new RegularPayments(uniqueID, amount, type, day);
                    sql.insertToTable(regularPayments);
                }
            }
        } while (choices != 6);
    }


}
