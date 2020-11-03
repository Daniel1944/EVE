package com.company;

import java.io.*;

public class InputOutput {
    Main m = new Main();
    File file = new File(m.USERNAME + ".txt");// deklarace souboru

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
            e.printStackTrace();
        }

    }

    public void writeToFile(String name, String info) {
        try {
            FileOutputStream fos = new FileOutputStream(name, true);
            byte[] b = info.getBytes();
            fos.write(b);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(String name) {
        InputStream input = null;
        try {
            input = new BufferedInputStream(new FileInputStream(name));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[8192];

        try {
            for (int length = 0; (length = input.read(buffer)) != -1;) {
                System.out.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
