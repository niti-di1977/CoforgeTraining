package com.infosys.utility;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infosys.exceptions.CourseCannotBeDeletedException;
import com.infosys.exceptions.CourseNotFoundException;

@RestControllerAdvice
public class ExceptionControllerAdvice
{
    @ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(CourseNotFoundException exp)
	{
    	ErrorInfo error = new ErrorInfo();
    	error.setErrorMessage(exp.getMessage());
    	error.setErrorCode(HttpStatus.NOT_FOUND.value());
    	error.setTimeStamp(LocalDateTime.now());  	
		return new ResponseEntity<ErrorInfo> (error,HttpStatus.NOT_FOUND);		
	}
    @ExceptionHandler(CourseCannotBeDeletedException.class)
   	public ResponseEntity<ErrorInfo> exceptionHandler(CourseCannotBeDeletedException exp)
   	{
       	ErrorInfo error = new ErrorInfo();
       	error.setErrorMessage(exp.getMessage());
       	error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
       	error.setTimeStamp(LocalDateTime.now());  	
   		return new ResponseEntity<ErrorInfo> (error,HttpStatus.INTERNAL_SERVER_ERROR);		
   	}
//    @ExceptionHandler(Exception.class)
//   	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exp)
//   	{
//       	ErrorInfo error = new ErrorInfo();
//       	error.setErrorMessage(" somethng went wrong please try again :( ");
//       	error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//       	error.setTimeStamp(LocalDateTime.now());  	
//   		return new ResponseEntity<ErrorInfo> (error,HttpStatus.INTERNAL_SERVER_ERROR);		
//   	}
}
