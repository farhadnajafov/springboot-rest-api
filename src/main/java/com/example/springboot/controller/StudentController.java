package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/getStudent")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Farhad",
                "Najafov"
        );
//        return new ResponseEntity<Student>(student,HttpStatus.OK);
        return  ResponseEntity.ok(student);
    }

    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Farhad","Najafov"));
        students.add(new Student(2,"Ali","Najafov"));
        students.add(new Student(3,"Shahin","Najafov"));

        return ResponseEntity.ok(students);
    }
    //http://localhost:8080/student/1/Farhad/Ilham
    @GetMapping("student/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                                       @PathVariable("first-name") String firstName,
                                                       @PathVariable("last-name")String lastName){

        Student student = new Student(studentId,firstName,lastName);
        return ResponseEntity.ok(student);
    }


    // http://localhost:8080/students/query?id=1
    @GetMapping("students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                                          @RequestParam String firstname,
                                                          @RequestParam String lastname){
        Student student = new Student(id,firstname,lastname);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/student/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student Successfully Deleted");
    }
}
