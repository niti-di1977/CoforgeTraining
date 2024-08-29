package com.company.demo.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsReceiver {
	
		@JmsListener(destination="testingmessage")
		public void recieveMessage(String message)
	
		{
			System.out.println("JMS Messaging Service");
			
		}

			}
