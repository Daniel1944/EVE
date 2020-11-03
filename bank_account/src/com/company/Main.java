package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import

public class Main {

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        bankAccount bA = new bankAccount();
        String name = sc.nextLine();
        String psw = sc.nextLine();

        if (bA.login(name, psw)) {
            System.out.println("Vitejte ve vasem bakonvnictvi " + name + ".");
        } else {
            System.out.println("Zadal jste spatne jmeno nebo heslo zkuste to znovu ");
            name = sc.nextLine();
            psw = sc.nextLine();
            bA.login(name, psw);
        }
        String menu = ("Vyberte si funkci" + "\n" + "1) Vyber" + "\n" + "2) Vklad" + "\n" + "3) Tranfer" + "\n" + "4) Historie transakci" + "\n" + "5) Odhlasit se");
        System.out.println(menu);
        int choice;
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Kolik peneze si prejete vybrat?");
                    int amount = sc.nextInt();
                    bA.withdraw(amount);
                    System.out.println("Vybral jste si: " + amount + "CZK." +"\n" + "Vas zustatek je: " + bA.balance + "CZK.");
                    System.out.println(menu);
                    break;
                case 2:
                    System.out.println("Vlozte penize");
                    amount = sc.nextInt();
                    bA.deposit(amount);
                    System.out.println("Vlozil jste si na ucet: " + amount + "CZK." +"\n" + "Vas zustatek je: " + bA.balance + "CZK.");
                    System.out.println(menu);
                    break;
                case 3:
                    System.out.println("Zadejte cislo uctu kam chcete prevest penize a jakou sumu chcete prevest.");
                    String accout = sc.nextLine();
                    amount = sc.nextInt();
                    bA.transfer(amount, accout);
                    System.out.println("Vlozil jste si na ucet: " + accout + " sumu" + amount +"CZK." +"\n" + "Vas zustatek je: " + bA.balance + "CZK.");
                    System.out.println(menu);
                    break;
                case 4:
                    System.out.println("Zde je vase historie transakci: ");
                    ArrayList<String> tmp = bA.previousTransaction;
                    System.out.println(Arrays.toString(tmp.toArray()));
                    System.out.println(menu);
                    break;
            }
        } while (choice != 5);
    }
}

class bankAccount {
    //konstanti s jmenenm a heslem
    private final static String USERNAME = "Daniel1944";
    private final static String PASSWORD = "heslo";
    //kolik mame penez na ucte
    int balance = 40000;
    //historie pohybu penez na ucte
    ArrayList<String> previousTransaction = new ArrayList<>();






    void deposit(int amount) {
        if (balance != 0) {
            balance = balance + amount;
            previousTransaction.add("+" + String.valueOf(amount) + " Category: Deposit");
        }
    }

    void withdraw(int amount) {
        if (balance != 0) {
            balance = balance - amount;

            previousTransaction.add("-" + String.valueOf(amount) + " Category: Withdraw");
        }
    }

    void transfer(int amount, String account) {
        if (account.length() == 16) {
            if (balance >= amount) {
                balance = balance - amount;
                previousTransaction.add("+" + String.valueOf(amount) + " Category: transfer to account(" + encAccount(account) + ")");
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
