package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ErrorPrinting {
    public void writeToFile( String info) {
        try {
            FileOutputStream fos = new FileOutputStream("exceptions", true);
            byte[] b = info.getBytes();
            fos.write(b);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
