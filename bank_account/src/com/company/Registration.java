package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Registration {

    static Scanner sc = new Scanner(System.in);
    Crypto.Caesar cs = new Crypto.Caesar();
    SQLQueries sqlQueries = new SQLQueries();

    void insertData() {
        System.out.println("Ahoj, vítá tě Eve tvá manažerka financí");
        System.out.println("Zadej zde své uživatelské jméno, email a heslo");
        System.out.println("JMENO: ");
        String name = sc.nextLine();
        System.out.println("EMAIL: ");
        String email = sc.nextLine();
        System.out.println("HESLO: ");
        String password = sc.nextLine();
        password = cs.encrypt(password);

        sqlQueries.insertToTable(name, email, password);

    }
}
