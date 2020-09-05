package com.karthi.rest.repository;

import com.karthi.rest.model.Student;
import com.karthi.rest.model.StudentRequest;

import java.util.List;

public interface StudentRepository {
    public List<Student> getStudentDetails();
    public Student getStudentById(Long id);
    public void addStudent(StudentRequest s);
    public void deleteStudent(long id);

}
