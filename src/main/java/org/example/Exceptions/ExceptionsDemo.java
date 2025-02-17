package org.example.Exceptions;

import java.util.Locale;

public class ExceptionsDemo {

    public static void show(){
sayHello(null);
    }

    public static void sayHello(String name){
        System.out.println("Hello "+name.toUpperCase());
    }

}
