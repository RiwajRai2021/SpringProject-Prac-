package com.bway.SpringProject.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@GetMapping("/upload")
	public String upload()
	
	{
		
		return "uploadForm";
	}
	@PostMapping("/upload")
	public String saveFile(@RequestParam("file") MultipartFile file, Model model) throws IOException
	{
		if(!file.isEmpty())
		{
			try {
				FileOutputStream fout = new FileOutputStream("src/main/resources/static/imgs/" +file.getOriginalFilename());
				
				fout.write(file.getBytes());
				fout.close();
				
				model.addAttribute("msg","upload success");
				return "uploadForm";
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		model.addAttribute("msg","upload fail");
		return "uploadForm";
	}
	
}
