package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    //http://localhost:8080/student/1/Farhad/Ilham
    @GetMapping("student/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name")String lastName){
        return new Student(studentId, firstName,lastName);
    }


    // http://localhost:8080/students/query?id=1
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id){
        return new Student(id, "Farhad","Najafov");
    }
}
