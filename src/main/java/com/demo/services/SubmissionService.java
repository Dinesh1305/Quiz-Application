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
		
		
		String ans=question.get(count).getRightanswer();
		
		if(ans.equals("option1"))
		{
			ans=question.get(count).getOption1();
		}
		
		else if(ans.equals("option2"))
		{
			ans=question.get(count).getOption2();
		}
		
		else	if(ans.equals("option3"))
		{
			ans=question.get(count).getOption3();
		}
		else	if(ans.equals("option4"))
		{
			ans=question.get(count).getOption4();
		}
		
		System.out.println(r.getAnswer_selected()+"  "+ans);
		
		
		if(r.getAnswer_selected().equals(ans))
			right_answer++;
		count++;
	}
	
	
	return right_answer;
	}
	
	
}
