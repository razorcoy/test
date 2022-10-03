package com.example.bcc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bcc.model.Student;
import com.example.bcc.repository.StudentRepository;
import com.example.bcc.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	@Override
	public String regisStudent(Student student) {
		String result = "Register Student Failed";

		if (student != null) {
			studentRepo.save(student);
			result = "Register Student Success";
		}

		return result;
	}

	@Override
	public String updateStudent(Student student) {
		String result = "Update Student Failed";

		Optional<Student> extStudent = studentRepo.findById(student.getNim());

		if (extStudent.isPresent()) {
		
			studentRepo.save(student);
			result = "Update Student Success";
		}

		return result;
	}

	@Override
	public String expelStudent(String nim) {
		String result = "Delete Student Failed";

		Optional<Student> extStudent = studentRepo.findById(nim);

		if (extStudent.isPresent()) {
			studentRepo.deleteById(nim);
			result = "Delete Student Success";
		}

		return result;
	}

}
