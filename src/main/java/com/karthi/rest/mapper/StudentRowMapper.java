package com.karthi.rest.mapper;

import com.karthi.rest.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student s = new Student();
        s.setId(rs.getLong("studentId"));
        s.setName(rs.getString("studentName"));
        s.setGender(rs.getString("studentGender"));
        return s;
    }
}
