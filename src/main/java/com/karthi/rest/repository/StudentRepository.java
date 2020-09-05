package com.karthi.rest.repository;

import com.karthi.rest.model.Student;

public interface StudentRepository {
    public void getStudentDetails();
    public Student getStudentById(Long id);
    public void addStudent(Student s);
    public void deleteStudent(long id);

}
