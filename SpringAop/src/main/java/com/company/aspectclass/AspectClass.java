package com.company.aspectclass;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {
	
	@Pointcut("execution(public * com.company.service.BusinessClass.businessMethod1())")
	public void pointCutExp()
	{}
	
	@Before("pointCutExp()")  // Joinpoint
	public void BeginTxn()
	{
		System.out.println("Transaction Started");
	}
	
	@After("pointCutExp()")
	public void sendReport()
	{
		System.out.println("Transaction Report Shared");
	}
	
	@AfterReturning("pointCutExp()")
	public void CommitTxn()
	{
		System.out.println("Transaction Committed");
	}
	
	@AfterThrowing(value="pointCutExp()", throwing="th")
	public void rollBackTxn(Throwable th)
	{
		System.out.println("Transaction Rolled Back" + th.getMessage());
		
	}

}
