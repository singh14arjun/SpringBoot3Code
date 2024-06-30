package com.example.SpringBoot_JPA.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBoot_JPA.course.course.Course;

public interface CourseSpringDatajpaRepository extends JpaRepository<Course, Long>
{
 List<Course>	findByAuthor(String author);
 List<Course>	findByName(String book_name);

}
