package com.karthi.rest.controllers;

import com.karthi.rest.model.Student;
import com.karthi.rest.model.StudentRequest;
import com.karthi.rest.repository.HashmapStudentRepository;
import com.karthi.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private StudentRepository s1;
   // HashmapStudentRepository hs1;

   StudentController(StudentRepository h1) {
        Objects.requireNonNull(h1);
        this.s1 = h1;
    }
   @GetMapping("/students/{id}")
    Student getStudent(@PathVariable Long id) {
        return s1.getStudentById(id);
    }
    @GetMapping("/students")
    List<Student> getStudents() {

        return s1.getStudentDetails();
    }

    @PostMapping("/students")
    public void postStudent(@RequestBody StudentRequest s) {
        Student newStudent = new Student();
       newStudent.setGender(s.getGender());
       newStudent.setName(s.getName());
             s1.addStudent(newStudent);
    }
     @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        s1.deleteStudent(id);
    }
}

