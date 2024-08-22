package com.hcl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice  //backend code which gets activated whenever the controllers are called
public class AllExceptionHandler 
{
	
	@ExceptionHandler(value=CourseAlreadyExistsException.class)
    @ResponseBody
	public ErrorResponse handleCourseAlreadyExist(CourseAlreadyExistsException ex)
	{
		ErrorResponse er=new ErrorResponse();
		er.setStatusCode(HttpStatus.CONFLICT.value());
		er.setMessage(ex.getMessage());
		return er;
	}
	
	@ExceptionHandler(value=CourseIdDoesNotExistException.class)
    @ResponseBody
	public ErrorResponse handleCourseDoesNotExist(CourseIdDoesNotExistException ex)
	{
		ErrorResponse er=new ErrorResponse();
		er.setStatusCode(HttpStatus.NOT_FOUND.value());
		er.setMessage(ex.getMessage());
		return er;
	}
	
}
