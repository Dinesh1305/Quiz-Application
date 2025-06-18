package com.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.Questions;
@Repository
public interface QuestionRepo extends JpaRepository <Questions,Integer> {

	
	
 public List<Questions> findByCategory(String c);
 @Query(
		  value = "SELECT * FROM questions WHERE category = :category ORDER BY RAND()",
		  countQuery = "SELECT COUNT(id) FROM questions WHERE category = :category",
		  nativeQuery = true
		)
 List<Questions> getByTopic(@Param("category") String category,
                            Pageable pageable);


}
