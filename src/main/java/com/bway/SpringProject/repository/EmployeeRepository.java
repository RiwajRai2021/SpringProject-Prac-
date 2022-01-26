package com.bway.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.SpringProject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	

}
