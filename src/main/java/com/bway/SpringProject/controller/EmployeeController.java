package com.bway.SpringProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.SpringProject.model.Employee;
import com.bway.SpringProject.repository.EmployeeRepository;
import com.bway.SpringProject.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository empRepo; 
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public String empForm(Model model, HttpSession session)
	{
		if(session.getAttribute("cuser")==null)
		{
			
			return "loginForm";
		}
		
		model.addAttribute("emodel", new Employee());	
		
		return "employeeForm";
	}
	
	@PostMapping("/employee")
	public String saveEmp(@ModelAttribute Employee Emp, HttpSession session)
	{
		if(session.getAttribute("cuser")==null)
		{
			
			return "loginForm";
		}
		
		empRepo.save(Emp);
		
		return "redirect:employee";
	}
	
	@GetMapping("/list")
	public String getAllEmp(Model model, HttpSession session)
	{
		if(session.getAttribute("cuser")==null)
		{
			
			return "loginForm";
		}
		
		model.addAttribute("elist", empRepo.findAll());
		
		return "list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session)
	{
		if(session.getAttribute("cuser")==null)
		{
			
			return "loginForm";
		}
		
		employeeService.deleteEmployee(id);
		//empRepo.deleteById(id);
		return "redirect:/list";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmp(@PathVariable int id, Model model, HttpSession session)
	{
		
		if(session.getAttribute("cuser")==null)
		{
			
			return "loginForm";
		}
		
		
		model.addAttribute("emodel", empRepo.getOne(id));
		return "editForm";
	}
}
