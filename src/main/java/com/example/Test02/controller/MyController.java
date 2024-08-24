package com.example.Test02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	// --- without database
//	public List<Student> getAllStudentList(){
//		return studentService.getAllStudents();
//	}
	// --- with database
	public Iterable<Student> getAllStudentList(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getSpecificStudent/{id}")
	public Student getSpecificStudent(@PathVariable String id){
		return studentService.getSpecificStudent(id);
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student){
	//public List<Student> addStudent(@RequestBody Student student){
		return studentService.addStudent(student);
	}
	@PutMapping("/updateStudent")
	//public String updateStudent(@RequestBody Student student) {
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/deleteMapping/{id}")
	public void deleteStudent(@PathVariable String id) {
	//public String deleteStudent(@PathVariable String id) {
		studentService.deleteStudent(id);
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
