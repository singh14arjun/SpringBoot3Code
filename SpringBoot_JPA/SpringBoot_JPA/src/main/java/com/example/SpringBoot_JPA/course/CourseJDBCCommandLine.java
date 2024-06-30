package com.example.SpringBoot_JPA.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.SpringBoot_JPA.course.course.Course;
//import com.example.SpringBoot_JPA.course.course.JPA.CourseJPARepositry;

@Component
public class CourseJDBCCommandLine implements CommandLineRunner
{
 
	/*
	 * @Autowired private CourseJDBCRepositry repo;
	 */	

	/*
	 * private CourseJPARepositry repo;
	 * 
	 * 
	 * 
	 * @Override public void run(String... args) throws Exception { repo.insert(new
	 * Course(1,"C","Kishor")); repo.insert(new Course(2,"HTML","Mansani"));
	 * 
	 * // repo.deleteById(1);
	 * 
	 * System.out.println(repo.findById(1)); }
	 */
	@Autowired
	private CourseSpringDatajpaRepository repo;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Course(1,"C","Kishor"));
		repo.save(new Course(2,"HTML","Mansani"));
		
//		repo.deleteById(1);
		
		System.out.println(repo.findById(1l));
		System.out.println(repo.findAll());
		System.out.println(repo.count());
		System.out.println(repo.findByAuthor("Arjun"));
		System.out.println(repo.findByName("C"));
	}

	
}
