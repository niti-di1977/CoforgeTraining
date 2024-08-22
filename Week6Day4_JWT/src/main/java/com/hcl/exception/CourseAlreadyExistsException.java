package com.hcl.exception;

public class CourseAlreadyExistsException extends RuntimeException
{
	private String msg;
	public CourseAlreadyExistsException(String msg)
	{
		super(msg);  //parent class constructor super()
		this.msg=msg;
	}
}
