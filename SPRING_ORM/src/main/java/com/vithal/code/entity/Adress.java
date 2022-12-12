package com.vithal.code.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "adresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Adress {
	
	@Id
	private int adressId;
	private String adressStreet;
	private String adressCountry;
	private String adressZipcode;

	
	//many adress to in one employee
	
	@ManyToOne
	@JoinColumn(name = "employee_Id")
	private Employee employee;
}
