package com.bway.SpringProject.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.SpringProject.utilities.EmailUtil;

@Controller
public class MailController {
	
	@GetMapping("/contact")
	public String emailForm()
	{
		
		return "email";
	}
	
	@PostMapping("/contact")
	public String sendEmail(HttpServletRequest request)
	{
		
		String to = request.getParameter("to");
		String subject = request.getParameter("subject");
		String message = request.getParameter("mesg");
		
		EmailUtil.sendEmail(to, subject, message);
		
		return "email";
	}

}
