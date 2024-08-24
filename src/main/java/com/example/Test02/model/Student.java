package com.example.Test02.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	
}
