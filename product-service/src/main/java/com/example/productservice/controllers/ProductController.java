package com.example.productservice.controllers;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.productservice.dto.GenericResponse;
import com.example.productservice.exceptions.ConfigurationException;
import com.example.productservice.exceptions.EntityNotFoundException;
import com.example.productservice.services.ProductService;
import com.example.productservice.util.GenericResponseUtils;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;
    
    @Value("${service.review.serviceId}")
    private String reviewServiceId;


 	@GetMapping(value = "/{productId}")
	public ResponseEntity findById(@PathVariable @NonNull String productId) throws EntityNotFoundException,
			ConfigurationException, InterruptedException, ExecutionException, TimeoutException {

		HashMap product = new HashMap(0);
		HashMap<String, Object> result = new HashMap<String, Object>();
		GenericResponse response=null;
		product=service.findById(productId);
		if (product.isEmpty()) {
			throw new EntityNotFoundException("No product found for id = " + productId);
		} 
        
        try {
        	 InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(reviewServiceId, false);
        	 response = restTemplate.getForObject(instanceInfo.getHomePageUrl() + "/api/review/"+productId, GenericResponse.class);

        }catch (RuntimeException e) {
        	//response=new GenericResponse("error",400, null,"No review found");
        	response=GenericResponseUtils.buildGenericResponseError("No review found");
        }
 
		result.put("product", product);
		result.put("reviews", response);
		return ResponseEntity.ok(GenericResponseUtils.buildGenericResponseOK(result));
	}

	 
}
