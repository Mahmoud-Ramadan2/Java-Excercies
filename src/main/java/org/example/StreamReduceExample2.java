package org.example;

import org.example.consumer.Instructor;
import org.example.consumer.Instructors;


import java.util.Optional;
import java.util.function.BinaryOperator;

public class StreamReduceExample2 {
    public static void main(String[] args) {
        //printing the instructor who has the highest years of experience

        BinaryOperator<Instructor> binaryOperator = (s1, s2) -> s1.getYearsOfExperience() > s2.getYearsOfExperience() ? s1 : s2;


        Optional<Instructor> instructor = Instructors.getAll().stream()
                .reduce((s1, s2) ->
                        s1.getYearsOfExperience() > s2.getYearsOfExperience() ? s1 : s2);

        instructor.ifPresent(System.out::println);
        System.out.println("__________________________________________________________");

        Optional<Instructor> instructor1 = Instructors.getAll().stream()
                .reduce((i1, i2) -> {
                    if (i1.getYearsOfExperience() > i2.getYearsOfExperience()) {
                        return i1;
                    } else {
                        return i2;
                    }

                });

        System.out.println(instructor1.get());


    }
}
