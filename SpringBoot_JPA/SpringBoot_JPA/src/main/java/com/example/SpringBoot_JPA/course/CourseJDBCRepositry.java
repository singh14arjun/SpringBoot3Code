package com.example.SpringBoot_JPA.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SpringBoot_JPA.course.course.Course;

@Repository
public class CourseJDBCRepositry {

	@Autowired
	private JdbcTemplate springJdbcTemplate;

	public static String SELECT_QUERY = """
			select * from course where id = ?;
			""";

	public static String INSERT_QUERY = """
			 insert into course values(?,?,?);
			""";

	public static String DELETE_QUERY = """
			delete from  course where id=?
			""";

	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public void deleteById(long id) {

		springJdbcTemplate.update(DELETE_QUERY, id);
	}

	public Course getCourseById(long id) {
	return	springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
	}
}
