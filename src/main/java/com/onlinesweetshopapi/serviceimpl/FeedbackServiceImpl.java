package com.onlinesweetshopapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetshopapi.domain.Feedback;
import com.onlinesweetshopapi.repository.FeedbackRepository;
import com.onlinesweetshopapi.service.FeedbackService;
@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	public Feedback saveOrUpdate(Feedback feedback) {
		// TODO Auto-generated method stub
		System.out.println(feedbackRepository);
		return feedbackRepository.save(feedback);
				
	}


	



	

}
