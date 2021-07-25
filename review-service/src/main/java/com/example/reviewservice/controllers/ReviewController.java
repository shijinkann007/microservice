package com.example.reviewservice.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reviewservice.annotations.Secured;
import com.example.reviewservice.dto.GenericResponse;
import com.example.reviewservice.entities.Review;
import com.example.reviewservice.exceptions.EntityNotFoundException;
import com.example.reviewservice.services.ReviewService;
import com.example.reviewservice.util.GenericResponseUtils;

@RestController
@RequestMapping(path = "/api/review")
public class ReviewController {

	@Autowired
	private ReviewService service;
	@GetMapping(value = "/{productId}")
 	public ResponseEntity<GenericResponse> findById(@PathVariable @NonNull String productId) throws EntityNotFoundException, TimeoutException {	 
		List<Review> reviewsByProductId = service.getReviewsGeneralData(productId);
		if (reviewsByProductId.isEmpty()) {
			throw new EntityNotFoundException("No reviews found for productId = " + productId);
		}		 
 		return ResponseEntity.ok(GenericResponseUtils.buildGenericResponseOK(processReviews(productId,reviewsByProductId)));

	}
	@GetMapping
	@Cacheable(value = "reviews")
	public ResponseEntity<GenericResponse> getReviews() throws EntityNotFoundException {
		List<Review> productReviews = service.findAll();
		if (productReviews.isEmpty()) {
			throw new EntityNotFoundException("No reviews found.");
		}
		return ResponseEntity.ok(GenericResponseUtils.buildGenericResponseOK(productReviews));
	}

	@Secured
	@PostMapping
	public ResponseEntity<GenericResponse> insertReview(@RequestBody @Valid Review review)
			throws EntityNotFoundException {
		Review reviewInserted = service.insert(review);
		return ResponseEntity.ok(GenericResponseUtils.buildGenericResponseOK(reviewInserted));
	}

	@Secured
	@PutMapping
	public ResponseEntity<GenericResponse> updateReview(@RequestBody @Valid Review review)
			throws EntityNotFoundException {
		Review reviewUpdated = service.save(review);
		return ResponseEntity.ok(GenericResponseUtils.buildGenericResponseOK(reviewUpdated));
	}

	@Secured
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<GenericResponse> deleteReview(@PathVariable String id) throws EntityNotFoundException {
		service.deleteReview(id);
		return ResponseEntity.ok(GenericResponseUtils.buildGenericResponseOK("Deleted Review with id : " + id));
	}
	
	public com.example.reviewservice.dto.ReviewsDTO processReviews(String productId, List<Review> reviewsByProductId) {
		if (!StringUtils.hasText(productId)) {
			throw new IllegalArgumentException("Invalid Product ID");
		}

		Double averageScore = reviewsByProductId.stream().filter(review -> productId.equals(review.getProductId()))
				.mapToDouble(Review::getScore).average().orElse(Double.valueOf(0));

		averageScore = round(averageScore, 2);

		long count = reviewsByProductId.stream().filter(review -> productId.equals(review.getProductId())).count();

		com.example.reviewservice.dto.ReviewsDTO reviewDTO = new com.example.reviewservice.dto.ReviewsDTO(productId,averageScore,count);

		return reviewDTO;
	}
	
	private double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

}
