package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	@Autowired
	private JdbcTemplate jdbc;
	
	private static String INSERT_QUERY = 
			"""
				insert into course (id, name, author)
				values(?, ?, ?);
			""";
	
	private static String DELETE_QUERY = 
			"""
				delete from course where id=?
			""";
	
	public void insert(Course course) {
		jdbc.update(INSERT_QUERY, 
				course.getId(), course.getName(), course.getAuthor());
	}
	
	public void delete(long id) {
		jdbc.update(DELETE_QUERY, id);
	}
}
