package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.services.Response;
import com.demo.services.SubmissionService;

@RestController
@RequestMapping("/submit")
public class ResponseController {

	@Autowired
	SubmissionService submissionservice;
	
	@PostMapping("/get/{id}")
	public Integer submit(@PathVariable Integer id,@PathVariable List<Response>res)
	{
		
		return submissionservice.Caculate(id, res);
	}
	
	
}
