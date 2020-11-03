package com.company;

import java.io.*;

public class InputOutput {

    public static void createFile(String name) {
        File file = new File("logs/" + name + ".txt");// deklarace souboru
        boolean rs;

        try {
            rs = file.createNewFile();//pokud se vytvori dosadi se true
            if (rs) {
                System.out.println("file created " + file.getCanonicalPath());
            } else {
                System.out.println("File already exist at location: " + file.getCanonicalPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String name, String info){
        try {
            FileOutputStream fos = new FileOutputStream(name, true);
            byte[] b = info.getBytes();
            fos.write(b);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(String name, String info){
        try {
            File file = new File(name); // instance souboru
            FileReader fr = new FileReader(file); //nacteni souboru
            BufferedReader br = new BufferedReader(fr);//ukladani dat do vyrovnavaci pameti
            StringBuffer sb = new StringBuffer();
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
