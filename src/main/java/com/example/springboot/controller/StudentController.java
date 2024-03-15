package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @PutMapping("/students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @DeleteMapping("/student/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        return "Student Deleted Successfully!";
    }
}
