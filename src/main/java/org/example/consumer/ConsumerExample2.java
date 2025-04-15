package org.example.consumer;

import org.example.consumer.Instructor;
import org.example.consumer.Instructors;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample2 {
    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();
        //looping through all the instructor and printing out the values of instructor
       Consumer<Instructor> c1 = (s1) -> System.out.println(s1);
     instructors.forEach(i->c1.accept(i));


        //Loop through all the instructor and only print out their name
        System.out.println("---------------");
        Consumer<Instructor> c2 = (s1) -> System.out.println(s1.getName());
        //instructors.forEach(c2);

        //Loop through all the instructors and print out their names and their courses
        System.out.println("----------------");
        Consumer<Instructor> ss = i-> System.out.println(i.courses);
       //instructors.forEach(c2.andThen(ss));

        //Loop through all the instructors and print out their name if the years of experience is >10
        System.out.println("----------");

        Consumer<Instructor> q = (i)-> {
            if(i.getYearsOfExperience()>10){
              c1.accept(i);
            }
        };
        instructors.forEach(q);

//        instructors.forEach(
//             i-> {   if(i.getYearsOfExperience()>10){
//                 System.out.println(i);
//             }
//             }
//        );


        //Loop through all the instructors and print out their name and years of experience if years
        //of experience is >5 and teaches course online
        System.out.println("--------------");
        Consumer<Instructor> aq = (i)-> {
            if(i.getYearsOfExperience() > 5 && !i.isOnlineCourses()){
            c2.andThen(ss).accept(i);
        }
        };
        instructors.forEach(aq);
//        instructors.forEach(s1->{
//            if (s1.getYearsOfExperience() > 5 && !s1.isOnlineCourses()){
//                c1.andThen(c2).accept(s1);
//            }
//        });



    }
}
