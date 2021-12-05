package com.onlinesweetshopapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetshopapi.domain.Feedback;
import com.onlinesweetshopapi.service.FeedbackService;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping
	public ResponseEntity<Feedback> createFeedback(@Validated @RequestBody Feedback feedback){
		Feedback createdFeedback= feedbackService.saveOrUpdate(feedback);
		return new ResponseEntity<Feedback>(createdFeedback, HttpStatus.CREATED);
	}

}
