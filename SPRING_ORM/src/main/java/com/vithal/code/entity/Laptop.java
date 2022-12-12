package com.vithal.code.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "laptops")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
	@Id
	private int laptopId;
	private String laptopBrand;
	private String laptopModel;
	@OneToOne
	private Student student;

}
