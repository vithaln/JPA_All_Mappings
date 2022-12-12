package com.vithal.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vithal.code.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
