package com.karthi.rest.controllers;

import com.karthi.rest.exceptions.StudentNotFoundException;
import com.karthi.rest.model.Student;
import com.karthi.rest.model.StudentRequest;
import com.karthi.rest.repository.HashmapStudentRepository;
import com.karthi.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<Student> getStudent(@PathVariable Long id)  {
       Student s;

       try
       {
          s= s1.getStudentById(id);
       }
       catch(StudentNotFoundException ex) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       return ResponseEntity.ok(s);
      }
    @GetMapping("/students")
    ResponseEntity<List<Student>> getStudents() {

        return ResponseEntity.ok(s1.getStudentDetails());
    }

    @PostMapping("/students")
    public ResponseEntity<Void> postStudent(@RequestBody StudentRequest s) {
        Student newStudent = new Student();
       newStudent.setGender(s.getGender());
       newStudent.setName(s.getName());
             s1.addStudent(newStudent);
        HttpHeaders header = new HttpHeaders();
        header.add("desc","One Student Added");
             return ResponseEntity.status(HttpStatus.OK).headers(header).build();
    }
     @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        s1.deleteStudent(id);
    }
}

