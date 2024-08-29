package com.company.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.demo.sender.JmsSender;

@SpringBootApplication
@RestController
public class JmsExampleApplication {
	
	@Autowired
	private JmsSender jmsSender;
	
	@PostMapping("/sendMessage")
	public void StringMessage(@RequestBody String message)
	{
		jmsSender.sendMessage(message);
		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(JmsExampleApplication.class, args);
	}

}
