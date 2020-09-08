package com.karthi.rest.repository;

import com.karthi.rest.model.Student;

import java.util.List;

public interface StudentRepository {
    public List<Student> getStudentDetails();
    public Student getStudentById(Long id);
    public void addStudent(Student s);
    public void deleteStudent(long id);

}
