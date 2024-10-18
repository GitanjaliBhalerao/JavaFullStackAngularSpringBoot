package com.ttl.trainingdemos.EmployeeManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/*
 * Customizing Error Response Structure
 * 
 * default error response provided by spring boot contains all the details 
 * in spring actuator response.
 * 
 * we wanted to create independent response structure for your org.
 * and you wanted to define a specific error response structure
 */

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message)
	{
		super(message);
	}

}
