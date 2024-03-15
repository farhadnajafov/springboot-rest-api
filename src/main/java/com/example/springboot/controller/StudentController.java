package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/getStudent")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Farhad",
                "Najafov"
        );
        return student;
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Farhad","Najafov"));
        students.add(new Student(2,"Ali","Najafov"));
        students.add(new Student(3,"Shahin","Najafov"));

        return students;
    }
}
