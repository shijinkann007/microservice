package com.example.productservice.controllers.advices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.productservice.dto.GenericResponse;
import com.example.productservice.exceptions.ConfigurationException;
import com.example.productservice.exceptions.EntityNotFoundException;
import com.example.productservice.util.GenericResponseUtils;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<GenericResponse> handleEntityNotFoundException(Exception e, WebRequest request) {
		ResponseEntity<GenericResponse> response = buildGenericResponse(e);
		return response;
	}

	@ExceptionHandler(ConfigurationException.class)
	public ResponseEntity<GenericResponse> handleConfigurationException(Exception e, WebRequest request) {
		ResponseEntity<GenericResponse> response = buildGenericResponse(e);
		return response;
	}

	private ResponseEntity<GenericResponse> buildGenericResponse(Exception e) {
		return ResponseEntity.badRequest().body(GenericResponseUtils.buildGenericResponseError(e));
	}

}
