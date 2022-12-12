package com.vithal.code.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	private String pId;
	private String pName;
	
	
	@ManyToMany(mappedBy = "product",fetch = FetchType.EAGER)
	private List<Cateory> category=new ArrayList<>();
	
	

}
