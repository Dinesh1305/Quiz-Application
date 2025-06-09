package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.services.Response;
import com.demo.services.SubmissionService;

@RestController
@RequestMapping("/submit")
public class ResponseController {

	@Autowired
	SubmissionService submissionservice;
	
	@GetMapping("/get/{id}")
	public Integer submit(@PathVariable Integer id,@RequestBody List<Response>res)
	{
		
		return submissionservice.Caculate(id, res);
	}
	
	
}
