package org.example;

import org.example.consumer.Instructor;
import org.example.consumer.Instructors;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample2 {
    public static void main(String[] args) {

        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Alex");
        Predicate<String> s = i-> i.startsWith("A");

        List<String> namew = names.stream().filter(i-> i.startsWith("A")).toList();

        //all instructor who teaches online
        Predicate<Instructor> p1 = (i) -> i.isOnlineCourses();
        //instructor experience is >10 years
        Predicate<Instructor> p2 = (i) -> i.getYearsOfExperience() >10;

        List<Instructor> instructors = Instructors.getAll();
        instructors.forEach(instructor -> {
            if (p1.test(instructor)){
                System.out.println(instructor);
            }
        });

        // is instructor teaches online and exprience is > 10 years
        System.out.println("---------------------");
        instructors.forEach(instructor ->  {
            if(p1.and(p2).test(instructor)){
                System.out.println(instructor);
            }
        });

    }
}
