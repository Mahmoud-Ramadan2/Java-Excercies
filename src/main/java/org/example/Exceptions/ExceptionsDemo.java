package org.example.Exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class ExceptionsDemo {


    public static void show(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("fllile.txt"));
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line =  bufferedReader.readLine();
            }
            bufferedReader.close();

        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }


    }



}
