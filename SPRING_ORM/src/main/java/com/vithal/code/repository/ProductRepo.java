package com.vithal.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vithal.code.entity.Product;

public interface ProductRepo  extends JpaRepository<Product, String>{

}
