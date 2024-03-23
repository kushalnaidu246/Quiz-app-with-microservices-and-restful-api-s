package com.kushal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kushal.dto.quizdto;
import com.kushal.model.Questionwrapper;
import com.kushal.model.Response;
import com.kushal.service.Quizservice;

@RestController
@RequestMapping("quiz")
public class Qiuzcontroller {
	
	@Autowired
	Quizservice quizservice;
	
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody quizdto dto  ){
		
		return quizservice.createquiz(dto.getCategory(),dto.getNumquestions(),dto.getTitle());
		
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<Questionwrapper>> getquizquestion(@PathVariable Integer id){
		
		return quizservice.getquizquestion(id);
		
		
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response>response){
	
		return quizservice.calculateresult(id,response);
	}

}

