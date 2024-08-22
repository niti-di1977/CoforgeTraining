package com.hcl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController 
{
	//http://localhost:8080/   : welcomeMsg()   
	@GetMapping("/")
	public String welcomeMsg()
	{
		return "Welcome to Security Session";
	}
	
	@GetMapping("/getAllProds")
	public String getAllProducts()
	{
		return "All Products retrieved";
	}

	@GetMapping("/add")
	public String addProduct()
	{
		return "Add Product Executed";
	}
	@GetMapping("/delete")
	public String deleteProduct()
	{
		return "Delete Product Executed";
	}
	@GetMapping("/update")
	public String updateProduct()
	{
		return "Update Product Executed";
	}

}


