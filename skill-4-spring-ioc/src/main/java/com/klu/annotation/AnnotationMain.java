package com.klu.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.klu.model.Student;

public class AnnotationMain {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        Student student = context.getBean(Student.class);

        student.setCourse("CSE");
        student.setYear(3);

        student.displayStudent();
    }
}