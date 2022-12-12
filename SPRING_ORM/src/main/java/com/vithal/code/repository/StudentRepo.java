package com.vithal.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vithal.code.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
