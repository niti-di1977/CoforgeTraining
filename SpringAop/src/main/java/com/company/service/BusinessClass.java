package com.company.service;

import org.springframework.stereotype.Service;

@Service
public class BusinessClass {

	public void businessMethod()
	{
		
		System.out.println("Business Method is getting executed");
		System.out.println(10/2);
	}
	
	public void businessMethod1()
	{
		
		System.out.println("Business Method1 is getting executed");
		System.out.println(10/0);
	}
}
