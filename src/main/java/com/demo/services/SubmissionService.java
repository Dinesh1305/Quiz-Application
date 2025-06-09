package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Questions;
import com.demo.model.Quiz;
import com.demo.repo.QuizRepo;

@Service
public class SubmissionService {

	@Autowired
	QuizRepo qr;
	public Integer Caculate(Integer id,List<Response>res)
	{
	Optional<Quiz> q=	qr.findById(id);
	
	
	List<Questions>question=q.get().getQuestion();
	
	
	int count=0;
	int right_answer=0;
	
	for(Response r:res)
	{
		if(r.getAnswer_selected().equals(question.get(count).getRightanswer()))
			right_answer++;
		count++;
	}
	
	
	return right_answer;
	}
	
	
}
