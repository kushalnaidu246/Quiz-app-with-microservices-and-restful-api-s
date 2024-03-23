package com.kushal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.kushal.model.Questionwrapper;
import com.kushal.model.Response;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface quizInterface {
    @GetMapping("question/generate")
    public static ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions ) {
		// TODO Auto-generated method stub
		return null;
	}

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<Questionwrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}
