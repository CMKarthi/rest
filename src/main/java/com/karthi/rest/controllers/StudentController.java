package com.karthi.rest.controllers;

import com.karthi.rest.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    HashMap<Long, Student> hashStudent = new HashMap<Long, Student>();
    Long hashStudentKey =1L;

    @GetMapping("/students/{id}")
    Student getStudent(@PathVariable Long id) {
        return hashStudent.get(id);
    }
    @GetMapping("/students")
    List<Student> getStudents() {

        return hashStudent.values()
                .stream()
                .collect(Collectors.toList());
           }

    @PostMapping("/students")
    public void postStudent(@RequestBody Student newStudent) {

        hashStudent.put(hashStudentKey++,newStudent);

    }
}

