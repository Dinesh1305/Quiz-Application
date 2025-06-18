package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService us;
	
	@GetMapping("get")
	public List<String> getTopic()
	{
		return us.getalltopic();
	}
}
