package com.example.SpringBoot1;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController 
{
	@GetMapping("/courses")
	public List<Course> getAllCourses()
	{
		return Arrays.asList(
				new Course(1,"Java","Ravi Shanakar"),
				new Course(2,"C","Kishor"),
				new Course(3,"Web Devlopement","Venketesh Mansani"),
		new Course(4,"Oracle","Shudhakar"));
	}

}
