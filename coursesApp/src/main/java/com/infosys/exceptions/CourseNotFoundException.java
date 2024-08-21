package com.infosys.exceptions;

public class CourseNotFoundException extends Exception {

	public  CourseNotFoundException()
	{
		super("the course you are looking for doesn't exist :( ");
	}
}
