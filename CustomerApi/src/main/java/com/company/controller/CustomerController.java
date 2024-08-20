package com.company.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.entities.Customer;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	private List<Customer> customer = createList();
	
	
	@PostMapping("/add")
	public String addCustomer()
	{
		
		return " customer Added";
	}
	
	@GetMapping(value="/getdetails" , produces="application/json")
	public List<Customer> viewAllCustomers()
	{
		return customer;
	}
	
	@DeleteMapping("/delete")
	public String deleteCustomer()
	{
		return "customer deleted";
	}
	
	@PutMapping("/update")
	public String updateCustomer()
	{
		return "customer details updated";
	}
	
	public static List<Customer> createList()
	{
		List<Customer> tempCustomer = new ArrayList<>();
		
		Customer c1 = new Customer(101,"Niti");
		
		Customer c2 = new Customer(102,"Jatin");
		
		tempCustomer.add(c1);
		tempCustomer.add(c2);
		
		return tempCustomer;
	}

}
