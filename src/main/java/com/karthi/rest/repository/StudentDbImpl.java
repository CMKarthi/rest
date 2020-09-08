package com.karthi.rest.repository;

import com.karthi.rest.mapper.StudentRowMapper;
import com.karthi.rest.model.Student;
import com.karthi.rest.model.StudentRequest;
import com.karthi.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDbImpl implements StudentRepository {

    public StudentDbImpl(NamedParameterJdbcTemplate template){
        this.template = template;
    }
    NamedParameterJdbcTemplate template;
    Long studentKey =1L;
    @Override
    public List<Student> getStudentDetails() {
        return template.query("select * from student", new StudentRowMapper());

    }

    @Override
    public Student getStudentById(Long id) {
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("studentId",id);

        return template.queryForObject("select * from student where studentId = :studentId",param,new StudentRowMapper());
        
    }

    @Override
    public void addStudent(Student s) {
        s.setId(studentKey);
        final String sql = "insert into student(studentName , studentGender) values(:studentName,:studentGender)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("studentName",s.getName())
                .addValue("studentGender", s.getGender());
        template.update(sql,param, holder);

    }

    @Override
    public void deleteStudent(long id) {

    }
}