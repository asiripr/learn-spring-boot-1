package com.example.Test02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Test02.model.Student;
import com.example.Test02.service.StudentService;

@RestController
public class MyController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/getAllStudentList")
	public List<Student> getAllStudentList(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getSpecificStudent/{id}")
	public Student getSpecificStudent(@PathVariable String id){
		return studentService.getSpecificStudent(id);
	}
	
	@PostMapping("/addStudent")
	public List<Student> addStudent(@RequestBody Student student){
		return studentService.addStudent(student);
	}
	@PutMapping("/updateStudent")
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	@GetMapping("/hi")
	public String name() {
		return "Asiri";
	}
	@GetMapping("/car")
	public String beep() {
		return "Toyota";
	}
}
