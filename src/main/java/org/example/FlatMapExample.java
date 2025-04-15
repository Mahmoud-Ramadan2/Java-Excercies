package org.example;


import org.example.consumer.Instructor;
import org.example.consumer.Instructors;

import java.awt.desktop.SystemEventListener;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        //Get a list of all the courses which instructors offers
//        List<String> instructorsCourses = Instructors.getAll().stream()
//                .peek(instructor -> System.out.println("Before Map: " + instructor))
//                .map(Instructor::getCourses)
//                .peek(instructor -> System.out.println("After Map: " + instructor))
//                .flatMap(List::stream)
//                .peek(instructor -> System.out.println("After Flat Map: " + instructor))
//                .collect(Collectors.toList());
//        System.out.println(instructorsCourses);
//        System.out.println("___________________");

        List<String> instructorsCourses = Instructors.getAll().stream()
                .map(i->i.getCourses())
                .flatMap(c->c.stream())
                .sorted(Comparator.comparing(c->!c.startsWith("C")))
                .collect(Collectors.toList());
instructorsCourses.forEach(System.out::println);
System.out.println("___________________");


    }

    private static class Foreach {
    }
}
