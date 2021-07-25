package com.example.productservice.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.productservice.exceptions.EntityNotFoundException;
import com.example.productservice.facade.ProductFacade;

@Service
public class ProductService {

	@Autowired
	@Qualifier("productFacadeRestImpl")
	private ProductFacade facade;

	public HashMap findById(String productId) throws EntityNotFoundException {
		return facade.getProduct(productId);
	}

}
