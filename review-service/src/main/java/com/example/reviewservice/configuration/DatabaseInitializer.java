package com.example.reviewservice.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.reviewservice.entities.Review;
import com.example.reviewservice.repositories.ReviewRepository;

@Component
public class DatabaseInitializer {

	private Logger LOG = Logger.getLogger(DatabaseInitializer.class);

	@Autowired
	private ReviewRepository reviewRepository;

	@PostConstruct
	public void init() {
		if (reviewRepository.findAll().isEmpty()) {
			
			reviewRepository.insert(getReviews());
			LOG.info(getReviews().size() + " Reviews inserted into the database.");
		}
	}

	public List<Review> getReviews() {
		List<Review> list = new ArrayList<>(0);
		
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));
		list.add(new Review("Review of M20324","Desc M20324",getRandomNumberBetween(0, 5),"M20324"));

		
		list.add(new Review("Review of BB5476","BB5476-desc",getRandomNumberBetween(0, 5),"BB5476"));
		list.add(new Review("Review of BB5476","BB5476-desc",getRandomNumberBetween(0, 5),"BB5476"));
		list.add(new Review("Review of BB5476","BB5476-desc",getRandomNumberBetween(0, 5),"BB5476"));
		list.add(new Review("Review of BB5476","BB5476-desc",getRandomNumberBetween(0, 5),"BB5476"));
		list.add(new Review("Review of BB5476","BB5476-desc",getRandomNumberBetween(0, 5),"BB5476"));
		list.add(new Review("Review of BB5476","BB5476-desc",getRandomNumberBetween(0, 5),"BB5476"));
		list.add(new Review("Review of BB5476","BB5476-desc",getRandomNumberBetween(0, 5),"BB5476"));
		list.add(new Review("Review of BB5476","BB5476-desc",getRandomNumberBetween(0, 5),"BB5476"));
		list.add(new Review("Review of BB5476","BB5476-desc",getRandomNumberBetween(0, 5),"BB5476"));
		list.add(new Review("Review of BB5476","BB5476-desc",getRandomNumberBetween(0, 5),"BB5476"));
		 


		

		return list;
	}

	public Integer getRandomNumberBetween(int minimum, int maximum) {
		Random rand = new Random();
		return minimum + rand.nextInt((maximum - minimum) + 1);
	}
}
