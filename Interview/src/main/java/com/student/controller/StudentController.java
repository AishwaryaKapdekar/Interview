package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentservice;

	@PostMapping("/student")
	public String addStudent(@RequestBody Student student) {
		String result = studentservice.addStudent(student);
		return result;
	}

	@GetMapping("/students")
	public List<Student> getAllStudent() {
		return studentservice.getAllStudents();		
	}

	@GetMapping("/student/{rollNumber}")
	public Student getStudent(@PathVariable("rollNumber")Long rollNumber) {
		return studentservice.getStudent(rollNumber);
	}
	
	@DeleteMapping("/student/{rollNumber}")
	public String deleteStudent(@PathVariable("rollNumber")Long rollNumber) {
		return studentservice.deleteStudent(rollNumber);
		
	}
}
