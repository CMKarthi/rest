package com.karthi.rest.repository;

import com.karthi.rest.exceptions.StudentNotFoundException;
import com.karthi.rest.mapper.StudentRowMapper;
import com.karthi.rest.model.Student;
import com.karthi.rest.model.StudentRequest;
import com.karthi.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDbImpl implements StudentRepository {

    public StudentDbImpl(NamedParameterJdbcTemplate template){
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    @Override
    public List<Student> getStudentDetails() {
        return template.query("select * from student", new StudentRowMapper());

    }

    @Override
    public Student getStudentById(Long id) {
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("studentId",id);

        List<Student> student = template.query("select * from student where studentId = :studentId",param,new StudentRowMapper());

        if(student.size()==0)
            throw new StudentNotFoundException("Student with id " + id + " not found");
        else
            return student.get(0);
    }

    @Override
    public void addStudent(Student s) {

        final String sql = "insert into student(studentName , studentGender) values(:studentName,:studentGender)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("studentName",s.getName())
                .addValue("studentGender", s.getGender());
        template.update(sql,param, holder);

    }

    @Override
    public void deleteStudent(long id) {
        final String sql = "delete from student where studentId=:studentId";

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("studentId", id);

        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException{
                return ps.executeUpdate();
            }
        });
    }
}