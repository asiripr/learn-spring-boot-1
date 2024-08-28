package com.example.Test02.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.Test02.model.Student;

public interface StudentRepository extends CrudRepository<Student, String>{
	
	@Query("SELECT s From Student s WHERE name=:name")
	public Student getStudentByName(@Param(value="name") String name);

}
