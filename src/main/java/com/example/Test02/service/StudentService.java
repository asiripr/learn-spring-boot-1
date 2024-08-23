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
		Student st1 = new Student();
		st1.setName("Sithum");
		st1.setId("001");
		st1.setEmail("sithum@gmail.com");
		
		Student st2 = new Student();
		st2.setName("Harini");
		st2.setId("002");
		st2.setEmail("harini@gmail.com");
		
		Student st3 = new Student();
		st3.setName("Janani");
		st3.setId("003");
		st3.setEmail("janani@gmail.com");
		
		studentList.add(st1);
		studentList.add(st2);
		studentList.add(st3);
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
}
