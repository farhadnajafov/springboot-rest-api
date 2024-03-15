package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
