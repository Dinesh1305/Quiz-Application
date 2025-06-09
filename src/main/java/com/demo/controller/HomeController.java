package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Questions;
import com.demo.services.QuestionService;

@RestController
public class HomeController {

	@Autowired
	QuestionService qs;
	
	@PostMapping("question")
	public String question(@RequestBody Questions u){

		
	qs.save(u);
		return "SAVE SUCCESSFULLY";
	}
	@PostMapping("saveAll")
	public void saveall(@RequestBody List<Questions>q)
	{
		qs.saveall(q);
	}
	
	
	
	@GetMapping("getQuestion")
	public ResponseEntity<List<Questions>> getquestion()
	{
		
   return qs.getall();
	}
	
	
	
    @GetMapping("/getcategory")
    public ResponseEntity<List<Questions>> getByRequestParam(@RequestParam String category) {
        return qs.getCategory(category);
    }
	
	@GetMapping("getcategory/{category}")
	public ResponseEntity<List<Questions>> getByCategory(@PathVariable  String category){
		
		return qs.getCategory(category);
	}
}
