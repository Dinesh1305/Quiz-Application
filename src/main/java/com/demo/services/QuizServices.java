package com.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.model.QuestionWrapper;
import com.demo.model.Questions;
import com.demo.model.Quiz;
import com.demo.repository.QuizRepo;

@Service
public class QuizServices {
	
	
	
	@Autowired
	QuestionService qs;
	

	
	@Autowired
	QuizRepo repo;
	public ResponseEntity<List<Questions>> create(String category, Pageable num, String title) {
		
		
		Quiz quiz=new Quiz();
		
		
		quiz.setTopic(title);
		
		quiz.setQuestion(qs.getQuestion(category,num));
		
		repo.save(quiz);
		return null;
	}
	public List<QuestionWrapper> getQuiz(Integer id) {
	 Optional<Quiz>r=repo.findById(id);
	 List<Questions>question=r.get().getQuestion();
	 List<QuestionWrapper>qw=new ArrayList<>();
	 for(Questions q:question)
	 {
		
		 qw.add(new QuestionWrapper(q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4()));
	 }
		return qw;
	}

}
