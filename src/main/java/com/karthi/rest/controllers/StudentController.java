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
    ArrayList<Student> getStudents() {
       //ArrayList<Student> studentArray = new ArrayList<Student>();
       // Collection<Student> values = hashStudent.values();
        ArrayList<Student> values
                = hashStudent.values().stream().collect(
                Collectors.toCollection(ArrayList::new));

       // ArrayList<Student> studentArray = new ArrayList<>(values);
        return values;
    }

    @PostMapping("/students")
    public void postStudent(@RequestBody Student newStudent) {

        hashStudent.put(hashStudentKey++,newStudent);
       // hashStudent.put(newStudent.getId(),newStudent);
    }
}
