package com.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Quiz;
import com.demo.repository.QuizRepo;

@Service
public class UserService {

	@Autowired
	QuizRepo quiz;
	
	public List<String> getalltopic()
	{
		List<String>n=new ArrayList<>();
		
		List<Quiz>q=quiz.findAll();
		for(Quiz k:q)
		{
			n.add(k.getTopic());
		}
			return n;
	}
	
	
}
