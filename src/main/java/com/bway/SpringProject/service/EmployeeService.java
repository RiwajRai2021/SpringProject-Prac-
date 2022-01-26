package com.bway.SpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.SpringProject.repository.EmployeeRepository;

@Service //logic layer or business layer
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void deleteEmployee(int id)
	{
		
		employeeRepository.deleteById(id);
	}
	
}
