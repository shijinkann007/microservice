package com.example.reviewservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.reviewservice.entities.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

	public List<Review> findByProductId(String productId);

}
