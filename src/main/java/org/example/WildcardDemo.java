package org.example;

import java.util.ArrayList;
import java.util.List;

class WildcardExample {
    public static  void printList(List<?> list) {  // Accepts any type
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();

    }
}

public class WildcardDemo {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3);
        List<String> strList = List.of("A", "B", "C");

        WildcardExample.printList(intList);
        WildcardExample.printList(strList);

        List<? super Integer> list = new ArrayList<Number>(); // ✅ Allowed
        list.add(10);  // ✅ Integer is allowed
        list.add(20);

       //list.add(10.5); ❌ Error: Cannot add Double
        //
        // list.add(new Object());
    }
}

