package com.example.reviewservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Review {

	@Id
	private String id;
	private String title;
	private String description;
	private Integer score;
	private String productId;
	
	public Review() {
		 
	}
	
	public Review(String title, String description, Integer score, String productId) {
		super();
		this.title = title;
		this.description = description;
		this.score = score;
		this.productId = productId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
}
