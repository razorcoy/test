package com.example.bcc.service;

import java.util.List;

import com.example.bcc.model.Student;

public interface StudentService {
	public List<Student> getAllStudent();
	
	public String regisStudent(Student student);
	
	public String updateStudent(Student student);
	
	public String expelStudent(String nim);
}
