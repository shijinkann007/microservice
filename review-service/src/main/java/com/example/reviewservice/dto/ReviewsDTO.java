package com.example.reviewservice.dto;


public class ReviewsDTO {
	private String productId;
	private Double averageScore;
	private Long quantity;
	
	
	public ReviewsDTO( ) { 
	}
	
	public ReviewsDTO(String productId, Double averageScore, Long quantity) {
		super();
		this.productId = productId;
		this.averageScore = averageScore;
		this.quantity = quantity;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(Double averageScore) {
		this.averageScore = averageScore;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
}
