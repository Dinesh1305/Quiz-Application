package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Quiz;

public interface QuizRepo  extends JpaRepository<Quiz,Integer>{

}
