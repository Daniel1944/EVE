package com.company;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ahoj mas ucet v EVE? (Y/N)");
        String choice = sc.nextLine();
        choice.toUpperCase();

        BankFunction bA = new BankFunction();
        Registration reg = new Registration();
        InputOutput io = new InputOutput();
        Login log = new Login();

        if (choice.equals("N")) {
            reg.insertData();
            io.createFile(log.USERNAME + ".txt");
        } else if (choice.equals("Y")) {
            log.insertLogin();
        }


        //System.out.println("Ahoj víta te tvá poradkyne Eve");
       /* String name = sc.nextLine();
        String psw = sc.nextLine();


        if (bA.login(name, psw)) {
            System.out.println("Vitejte ve vasem bakonvnictvi " + name + ".");
        } else {
            System.out.println("Zadal jste spatne jmeno nebo heslo zkuste to znovu ");
            name = sc.nextLine();
            psw = sc.nextLine();
            bA.login(name, psw);
        }
*/
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
                    bA.withdraw(amount);
                    System.out.println("Vybral jste si: " + amount + "CZK." + "\n" + "Vas zustatek je: " + bA.balance + "CZK.");
                    System.out.println(menu);
                }
                case 2 -> {
                    System.out.println("Vlozte penize");
                    amount = sc.nextInt();
                    bA.deposit(amount);
                    System.out.println("Vlozil jste si na ucet: " + amount + "CZK." + "\n" + "Vas zustatek je: " + bA.balance + "CZK.");
                    System.out.println(menu);
                }
                case 3 -> {
                    System.out.println("Zadejte cislo uctu kam chcete prevest penize a jakou sumu chcete prevest.");
                    String accout = sc.nextLine();
                    amount = sc.nextInt();
                    bA.transfer(amount, accout);
                    System.out.println("Vlozil jste si na ucet: " + accout + " sumu" + amount + "CZK." + "\n" + "Vas zustatek je: " + bA.balance + "CZK.");
                    System.out.println(menu);
                }
                case 4 -> {
                    System.out.println("Zde je vase historie transakci: ");
                    io.readFile(log.USERNAME + ".txt");
                    System.out.println(menu);
                }
            }
        } while (choices != 5);
    }


}
