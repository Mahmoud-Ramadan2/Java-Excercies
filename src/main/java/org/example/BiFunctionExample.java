package org.example;

import org.example.consumer.Instructor;
import org.example.consumer.Instructors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {
    public static void main(String[] args) {
        //Bifuction 2 inputs List<Instructors> and second is predicate which will filter if instructor has online
        //courses and return a map of <String,Integer> string is name and Integer is the years of experience

        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7);
        int max = numbers.stream().min(Integer::compare).get();
        Predicate<Instructor> p1 = Instructor::isOnlineCourses;
        BiFunction<List<Instructor>, Predicate<Instructor>, Map<String,Integer>> mapBiFunction =
                ((instructors, instructorPredicate) -> {
                    Map<String, Integer> map = new HashMap<>();
                    instructors.forEach(instructor -> {
                        if(instructorPredicate.test(instructor)){
                            map.put(instructor.getName(), instructor.getYearsOfExperience());
                        }
                    });
                    return map;
                });

        BiFunction<List<Instructor>,Predicate<Instructor>,Map<String,Integer>> mapBiFunction1 =
                (instracors,insp)->{
                    Map<String, Integer> map = new HashMap<>();
                    instracors.forEach(
                    i->{
                        if(insp.test(i)){
                            map.put(i.getName(),i.getYearsOfExperience());
                        }
                    }
            );

            return map;
                };



        System.out.println(mapBiFunction.apply(Instructors.getAll(), p1));
        System.out.println(mapBiFunction1.apply(Instructors.getAll(), p1));

    }
}
