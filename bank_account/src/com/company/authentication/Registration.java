package com.company.authentication;

import com.company.functionalities.CryptoFunction;

import java.util.Scanner;

public class Registration {

    private static final String ADMIN_TOKEN_KEY = "XYZFF00";
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

        System.out.println("Máte administrační token? \n Pokud ano tak ho zadaejte pokud ne zadejte N");
        String token = sc.nextLine();
        String role;
        if (token.equals(ADMIN_TOKEN_KEY))
            role = "admin";
        else
            role = "user";

        SQLQueries.User user = new SQLQueries.User(name, email, password, role, 0);

        sqlQueries.insertToTable(user);


    }
}
