package com.kushal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kushal.dao.Quizdao;
import com.kushal.feign.quizInterface;
import com.kushal.model.Questionwrapper;
import com.kushal.model.Quiz;
import com.kushal.model.Response;

@Service
public class Quizservice {
	
	@Autowired
	Quizdao quizdao;
	
	 @Autowired
	 quizInterface quizInterface;
	

	public ResponseEntity<String> createquiz(String category, int numQ, String title) {
		List<Integer> questions = com.kushal.feign.quizInterface.getQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizdao.save(quiz);

		
		
		
		return new ResponseEntity<>("Sucess",HttpStatus.ACCEPTED);
	}


	public ResponseEntity<List<Questionwrapper>> getquizquestion(Integer id) {
		 Quiz quiz = quizdao.findById(id).get();
         List<Integer> questionIds = quiz.getQuestionIds();
         ResponseEntity<List<Questionwrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
         return questions;
	}


	public ResponseEntity<Integer> calculateresult(Integer id, List<Response> response) {
		 
		  ResponseEntity<Integer> score = quizInterface.getScore(response);
	        return score;
		    }
	}
	


