package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.company.service.BusinessClass;


public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext ctx = new AnnotationConfigApplicationContext(config.class);
       
       BusinessClass service = ctx.getBean(BusinessClass.class);
       
       service.businessMethod1();
    }
}
