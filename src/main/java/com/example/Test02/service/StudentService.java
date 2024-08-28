package com.example.Test02.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.example.Test02.model.Student;
import com.example.Test02.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	
	@Autowired // used for dependency injection
	StudentRepository studentRepository;
	
	//List<Student> studentList = new ArrayList<Student>(); we use this when we manually insert data through the java code
	List<Student> studentList = null;
	
	public StudentService() {
		studentList = new ArrayList<Student>();
	}
	// --- with no database
//	public List<Student> getAllStudents(){
//		return studentList;
//	}
	// --- with database
	public Iterable<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	// --- no database
//	public Student getSpecificStudent(String id) {
//		return studentList.stream().filter(s->s.getId().equals(id)).findFirst().get();
//	}
	// --- with database
	public Student getSpecificStudent(String id) {
		return studentRepository.findById(id).get();
	}
	
	public Student addStudent(Student student){
	//public List<Student> addStudent(Student student){
		//studentList.add(student);
		//return studentList;
		// return Stream.of(student).collect(Collectors.toCollection(()->studentList)); //same operation using lamda expression // we use this to add student to the array list
		return studentRepository.save(student);
	}
	public Student updateStudent(Student student) {
	//public String updateStudent(Student student) {
//		for(Student s: studentList) {
//			if(s.getId().equals(student.getId())) {
//				s.setEmail(student.getEmail());
//				s.setName(student.getName());
//			}
//		}
		
		// --- this part uses when we manipulate system without database ---
//		try {
//			studentList.stream().filter(s->s.getId().equals(student.getId())).forEach(s->{s.setName(student.getName());s.setEmail(student.getEmail());});
//			return "Successfully Updated!";
//		} catch (Exception e) {
//			return "An error occurred!";
//		}
		
		// --- with database
		return studentRepository.save(student);
	}
	
	public void deleteStudent(String id) {
	//public String deleteStudent(String id) {
//		for(Student s: studentList) {
//			if(s.getId().equals(id)) {
//				studentList.remove(s);
//			}
//		}
		
		// --- when no database
//		boolean result = studentList.removeIf(s->s.getId().equals(id));
//		if(result) {
//			return "successfully deleted";
//		}
//		else {
//			return "something went wrong";
//		}
		
		// --- with database
		studentRepository.deleteById(id);
	}
	
	public Student getStudentByName(String name) {
		return studentRepository.getStudentByName(name);
	}
	
	@Transactional//(dontRollbackOn = Propagation.REQUIRED)
	public void updateStudentEmail(String email, String id) {
		studentRepository.updateStudentEmail(email, id);
	}
}
