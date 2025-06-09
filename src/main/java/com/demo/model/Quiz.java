package com.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE)

	private Integer id;
	private String topic;
	
	@ManyToMany
	private List<Questions>question;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<Questions> getQuestion() {
		return question;
	}

	public void setQuestion(List<Questions> question) {
		this.question = question;
	}


	
	
	
	
	
}
