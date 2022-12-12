package com.vithal.code.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	
	@Id
	private int empId;
	private String empName;
	private String empCity;
	private String empAbout;
	
	
	//one employee can have many adress
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	private List<Adress> adressList=new ArrayList<>();
}
