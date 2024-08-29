package com.company.demo.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {

	
	@Autowired
	
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(String message)
	
	{
		
		jmsTemplate.convertAndSend("testingmessage",message);
	}
}
