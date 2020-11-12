package com.company.authentication;

import com.company.functionalities.CryptoFunction;

import java.util.Scanner;

public class Registration {

    static Scanner sc = new Scanner(System.in);
    CryptoFunction.Caesar cs = new CryptoFunction.Caesar();
    SQLQueries sqlQueries = new SQLQueries();

    public void insertData() {
        //pouze docasne do doby UI
        System.out.println("Ahoj, vítá tě Eve tvá manažerka financí");
        System.out.println("Zadej zde své uživatelské jméno, email a heslo");
        System.out.println("JMENO: ");
        String name = sc.nextLine();
        System.out.println("EMAIL: ");
        String email = sc.nextLine();
        System.out.println("HESLO: ");
        String password = sc.nextLine();
        password = cs.encrypt(password);

        SQLQueries.User user = new SQLQueries.User(name, email, password);

        sqlQueries.insertToTable(user);

    }
}
