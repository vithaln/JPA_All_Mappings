package com.vithal.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vithal.code.entity.Cateory;

public interface CategoryRepo extends JpaRepository<Cateory, String>{

}
