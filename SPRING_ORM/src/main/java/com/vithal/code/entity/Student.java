package com.vithal.code.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	private int studentId;
	private String studentName;
	private String studentAbout;
	private String studentCity;
	
	
	@OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
	private Laptop laptop;
}
