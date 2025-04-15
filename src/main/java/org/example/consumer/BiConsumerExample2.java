package org.example.consumer;


import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample2 {
    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();
        //print out name and gender of instructors
        BiConsumer<String, String> biConsumer = (name, gender) -> System.out.println("name is :"
            + name + " and gender is: " + gender);
        instructors.forEach(instructor ->
                biConsumer.accept(instructor.getName(), instructor.getGender()));
        instructors.forEach(i->
                biConsumer.accept(i.getGender(),i.getName())
        );

        //print out name and list of courses
        System.out.println("--------------------");

        BiConsumer<String,List<String>> biConsumer2 = (a,b)-> System.out.println("name is "+a+ "with corcses "+b );
        instructors.forEach(
                i-> biConsumer2.accept(i.getName(),i.getCourses())
        );

        //print out name and gender of all instructors who teaches online
        System.out.println("----------------------");
        instructors.forEach(instructor -> {
             if (instructor.isOnlineCourses())
                 biConsumer.accept(instructor.getName(), instructor.getGender());
        });


    }
}
