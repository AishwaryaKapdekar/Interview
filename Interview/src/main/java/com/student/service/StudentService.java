package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentRepository;
import com.student.model.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentrepository;
	public String addStudent(Student student) {
		Student std = studentrepository.save(student);
		return "Student "+std.getFirstName()+" has been added...!";
	}
	public List<Student> getAllStudents() {
		List<Student> stds = (List<Student>) studentrepository.findAll();
		return stds;
	}
	public Student getStudent(Long rollNumber) {
		Optional<Student> std = studentrepository.findById(rollNumber);
		return std.isPresent()? std.get():new Student();
	}
	public String deleteStudent(Long rollNumber) {
		studentrepository.deleteById(rollNumber);
		return "Student has been deleted...!";
	}
}
