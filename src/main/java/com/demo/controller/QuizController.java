package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.QuestionWrapper;
import com.demo.model.Questions;
import com.demo.services.QuizServices;

@RestController

@RequestMapping("quiz")
public class QuizController {

	
	@Autowired
	private QuizServices quiz;
	
	@PostMapping("create")
	public ResponseEntity<List<Questions>> create(@RequestParam String Category ,@RequestParam int num,@RequestParam String title){
		
		Pageable pg= Pageable.ofSize(num);
		return quiz.create(Category,pg,title);
		
	}
	
	
	@GetMapping("/get/{id}")
	public List<QuestionWrapper> get(@PathVariable Integer id)
	{
		
		
		return quiz.getQuiz(id);
	}
	
	
	
	
}
