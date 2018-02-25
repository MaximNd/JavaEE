package data.DAO.impl;

import data.DAO.StudentsDao;
import data.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Макс on 25.02.2018.
 */
@Component
public class JdbcStudentsDao implements StudentsDao {
    private static final String SQL_INSERT_STUDENT = "insert into students (pib,course) values (?,?)";
    private static final String SQL_SELECT_STUDENT_BY_ID = "select id, pib, course from students where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addStudent(Student student) {
        jdbcTemplate.update(SQL_INSERT_STUDENT,
                student.getPib(),
                student.getCourse());
    }

    public Student getStudentById(int id){
        return jdbcTemplate.queryForObject(SQL_SELECT_STUDENT_BY_ID,
                new RowMapper<Student>() {
                    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Student student = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3));
                        return student;
                    }
                },id);
    }


}
