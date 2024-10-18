package com.ttl.trainingdemos.EmployeeManagementSystem.exception;

import java.util.Date;

/*
 * To use ErrorDetails to return error response
 * 
 * let's create GlobalExceptionHandler - handles exceptions-specific
 * and global exceptions at a single place
 * 
 */

public class ErrorDetails {

	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
