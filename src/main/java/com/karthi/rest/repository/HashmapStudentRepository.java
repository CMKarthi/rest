package com.karthi.rest.repository;

import com.karthi.rest.model.Student;
import com.karthi.rest.model.StudentRequest;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HashmapStudentRepository implements StudentRepository{
    HashMap<Long, Student> hashStudent = new HashMap<Long, Student>();
    Long hashStudentKey =1L;
    @Override
    public List<Student> getStudentDetails() {
        return hashStudent.values()
                .stream()
                .collect(Collectors.toList());

    }

    @Override
    public Student getStudentById(Long id) {
        return hashStudent.get(id);
    }

    @Override
    public void addStudent(StudentRequest s) {
        Student newStudent = new Student(hashStudentKey,s.getName(),s.getGender());

        hashStudent.put(hashStudentKey,newStudent);
        hashStudentKey= hashStudentKey+1;

    }

    @Override
    public void deleteStudent(long id) {
        hashStudent.remove(id);

    }
}
