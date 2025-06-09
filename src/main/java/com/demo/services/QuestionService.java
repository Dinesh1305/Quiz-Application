package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.model.Questions;
import com.demo.repo.QuestionRepo;

@Service
public class QuestionService {

	@Autowired
	QuestionRepo qr;
	
	public ResponseEntity<List<Questions>> getall()
	{
	return new 	ResponseEntity<>(qr.findAll(),HttpStatus.OK);
	}
	
	
	public Questions  save(Questions s)
	{
		return qr.save(s);
	}
	
	public ResponseEntity<List<Questions>> getCategory(String category)
	{
		return new ResponseEntity<>(qr.findByCategory(category),HttpStatus.OK);
	}


	public List<Questions> getQuestion(String category, Pageable num) {
	
		return qr.getByTopic(category,num);
	}


	public void saveall(List<Questions> q) {
		// TODO Auto-generated method stub
		qr.saveAll(q);
		
	}


	
	
	
	
	
}
