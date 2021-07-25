package com.example.reviewservice.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.reviewservice.entities.Review;
import com.example.reviewservice.exceptions.EntityNotFoundException;
import com.example.reviewservice.repositories.ReviewRepository;



@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;

	

	public List<Review> findAll() {
		return repository.findAll();
	}
	
	public List<Review> getReviewsGeneralData(String productId) throws EntityNotFoundException {
		return repository.findByProductId(productId);
		 
	}

	public Review insert(@Valid Review review) throws EntityNotFoundException {
 		return repository.insert(review);
	}

	public Review save(@Valid Review review) throws EntityNotFoundException {
 		return repository.save(review);
	}

	public void deleteReview(String reviewId) throws EntityNotFoundException {
		if (!StringUtils.hasText(reviewId)) {
			throw new EntityNotFoundException("Review ID not provided.");
		}
		Optional<Review> findById = repository.findById(reviewId);
		if (findById.isPresent()) {
			repository.deleteById(reviewId);
		} else {
			throw new EntityNotFoundException("Review with id = " + reviewId + " not found.");
		}
	}
	
	

}
