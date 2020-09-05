package com.karthi.rest.controllers;

import com.karthi.rest.model.Student;
import com.karthi.rest.model.StudentRequest;
import com.karthi.rest.repository.HashmapStudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class StudentController {
   /* HashMap<Long, Student> hashStudent = new HashMap<Long, Student>();
    Long hashStudentKey =1L;*/
    HashmapStudentRepository h1= new HashmapStudentRepository();

    @GetMapping("/students/{id}")
    Student getStudent(@PathVariable Long id) {
        return h1.getStudentById(id);
    }
    @GetMapping("/students")
    List<Student> getStudents() {

        return h1.getStudentDetails();
    }

    @PostMapping("/students")
    public void postStudent(@RequestBody StudentRequest s) {
        h1.addStudent(s);
    }
     @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        h1.deleteStudent(id);
    }
}

