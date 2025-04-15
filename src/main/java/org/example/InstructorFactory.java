package org.example;

import org.example.consumer.Instructor;

import java.util.List;

public interface InstructorFactory {

    public Instructor getInstructor(String name, int yearsOfExperience, String title, String gender, boolean onlineCourses, List<String> courses);
}
