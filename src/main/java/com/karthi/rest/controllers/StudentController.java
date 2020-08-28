package com.karthi.rest.controllers;

import com.karthi.rest.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/students/{id}")
    Student getStudent(@PathVariable Long id) {
        return new Student(id, "Samyu");
    }
    @GetMapping("/students")
    List<Student> getStudents() {
        Student s1 = new Student(1,"Samyu");
        Student s2 = new Student(2,"Cherry");
        Student s3 = new Student(3,"Karthi");
        Student s4 = new Student(4,"Saran");
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        return studentList;
    }

}
