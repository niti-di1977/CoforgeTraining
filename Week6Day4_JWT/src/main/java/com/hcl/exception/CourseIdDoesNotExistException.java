package com.hcl.exception;

public class CourseIdDoesNotExistException extends RuntimeException
{
	private String msg;
	public CourseIdDoesNotExistException(String msg)
	{
		super(msg);  //parent class constructor super()
		this.msg=msg;
	}
	
}
