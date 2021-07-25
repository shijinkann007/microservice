package com.example.productservice.facade;

import java.util.HashMap;

import com.example.productservice.exceptions.EntityNotFoundException;

public interface ProductFacade {

	public HashMap getProduct(String productId) throws EntityNotFoundException;
}
