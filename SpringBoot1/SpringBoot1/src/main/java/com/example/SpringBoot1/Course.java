package com.example.SpringBoot1;

public class Course {
    private long id;
    private String name;
    private String teacher;
    
    public Course(long id, String name, String teacher) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
	}
    
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTeacher() {
		return teacher;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", teacher=" + teacher + "]";
	}
	
	
}
