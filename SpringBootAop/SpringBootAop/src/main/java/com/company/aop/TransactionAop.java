package com.company.aop;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAop {
	
	@Pointcut("execution(public * com.company.service.BusinessClass.businessMethod())")
	public void pointCutExp()
	{}
	
	
	@Pointcut("@annotation(com.company.myannotation.MyAnno)")
	public void pointCutExp2()
	{}
//	@Before("pointCutExp()")  // Joinpoint
//	public void BeginTxn()
//	{
//		System.out.println("Transaction Started");
//	}
//	
//	@After("pointCutExp()")
//	public void sendReport()
//	{
//		System.out.println("Transaction Report Shared");
//	}
//	
//	@AfterReturning("pointCutExp()")
//	public void CommitTxn()
//	{
//		System.out.println("Transaction Committed");
//	}
//	
//	@AfterThrowing(value="pointCutExp()", throwing="th")
//	public void rollBackTxn(Throwable th)
//	{
//		System.out.println("Transaction Rolled Back" + th.getMessage());
//		
//	}
	
	@Around("pointCutExp2()")
	public void aroundTest(ProceedingJoinPoint jp)
	{
		//befor advice
		System.out.println("Transcation support initiated .....");
		
	
	
	try
	{
		jp.proceed();
		//jp.proceed(); //  code to call you business method
		//after returning advice
		System.out.println("Transcation Committed .....");
	}
	
	catch(Throwable t)
	{
		//after throwing
		System.out.println(t.getMessage() + " Transaction rolled Back  .....");
	}
   
	//after advice
	System.out.println("report emailed .....");
}
}
