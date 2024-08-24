package com.example.Test02.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.Test02.model.Student;

@Service
public class StudentService {
	List<Student> studentList = new ArrayList<Student>();
	
	public StudentService() {
		
	}
	
	public List<Student> getAllStudents(){
		return studentList;
	}
	
	public Student getSpecificStudent(String id) {
		return studentList.stream().filter(s->s.getId().equals(id)).findFirst().get();
	}
	
	public List<Student> addStudent(Student student){
		//studentList.add(student);
		//return studentList;
		return Stream.of(student).collect(Collectors.toCollection(()->studentList)); //same operation using lamda expression
	}
	
	public String updateStudent(Student student) {
//		for(Student s: studentList) {
//			if(s.getId().equals(student.getId())) {
//				s.setEmail(student.getEmail());
//				s.setName(student.getName());
//			}
//		}
		try {
			studentList.stream().filter(s->s.getId().equals(student.getId())).forEach(s->{s.setName(student.getName());s.setEmail(student.getEmail());});
			return "Successfully Updated!";
		} catch (Exception e) {
			return "An error occured!";
		}
	}
	
	public String deleteStudent(String id) {
//		for(Student s: studentList) {
//			if(s.getId().equals(id)) {
//				studentList.remove(s);
//			}
//		}
		boolean result = studentList.removeIf(s->s.getId().equals(id));
		if(result) {
			return "successfully deleted";
		}
		else {
			return "something went wrong";
		}
	}
}
