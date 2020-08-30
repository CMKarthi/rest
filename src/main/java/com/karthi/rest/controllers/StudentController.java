package com.karthi.rest.controllers;

import com.karthi.rest.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    HashMap<Long, Student> hashStudent = new HashMap<Long, Student>();
    Long hashStudentKey =1L;

    @GetMapping("/students/{id}")
    Student getStudent(@PathVariable Long id) {
        return (hashStudent.get(id));
    }
    @GetMapping("/students")
    HashMap<Long, Student> getStudents() {

        return hashStudent;
    }

    @PostMapping("/students")
    public void postStudent(@RequestBody Student newStudent) {

        hashStudent.put(hashStudentKey++,newStudent);
       // hashStudent.put(newStudent.getId(),newStudent);
    }
}
