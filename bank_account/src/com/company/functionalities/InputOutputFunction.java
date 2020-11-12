package com.company.functionalities;

import com.company.authentication.Login;
import com.company.interfaces.BasicInputOutput;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InputOutputFunction implements BasicInputOutput {
    Login loginName = new Login();
    File file = new File("userD.txt");// deklarace souboru


    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    @Override
    public void writeErrorToFile(String info) {
        try {
            FileOutputStream fos = new FileOutputStream("exceptions", true);
            byte[] b = info.getBytes();
            fos.write(b);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createFile(String name) {
        boolean rs;

        try {
            rs = file.createNewFile();//pokud se vytvori dosadi se true
            if (rs) {
                System.out.println("file created " + file.getCanonicalPath());
            } else {
                System.out.println("File already exist at location: " + file.getCanonicalPath());
            }
        } catch (IOException e) {
            writeErrorToFile("ERROR IOException:" + "\n Chyba v metode createFile: " + e.toString() + "\n V case: " + dtf.format(now));
        }

    }

    @Override
    public void writeToFile(String name, String info) {
        try {
            FileOutputStream fos = new FileOutputStream(name, true);
            byte[] b = info.getBytes();
            fos.write(b);
            fos.close();

        } catch (IOException e) {
            writeErrorToFile("ERROR IOException:" + "\n Chyba v metode writeToFile: " + e.toString() + "\n V case: " + dtf.format(now));
        }
    }

    @Override
    public void readFile(String name) {
        InputStream input = null;
        try {
            input = new BufferedInputStream(new FileInputStream(name));
            byte[] buffer = new byte[8192];
            for (int length = 0; (length = input.read(buffer)) != -1; ) {
                System.out.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            writeErrorToFile("ERROR IOException:" + "\n Chyba v metode readFile: " + e.toString() + "\n V case: " + dtf.format(now));
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                writeErrorToFile("ERROR IOException:" + "\n Chyba v metode readFile ve final bloku: " + e.toString() + "\n V case: " + dtf.format(now));
            }
        }
    }

}
