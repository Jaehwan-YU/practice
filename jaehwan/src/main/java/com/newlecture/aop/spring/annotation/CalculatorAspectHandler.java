package com.newlecture.aop.spring.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

@Aspect
public class CalculatorAspectHandler {
	
	@Before("execution(* *..NewlecCalculator.add(..))")
	public void authorHandler() {
		System.out.println("권한확인");
	}
	
	@AfterReturning(pointcut="execution(* *..NewlecCalculator.add(..))",
			 returning="returnValue")
	public void after(JoinPoint joinPoint, Object returnValue) {
		int result = (Integer)returnValue;
		if(result >= 0)
				System.out.println("양수입니다.");
	}
	
	@AfterThrowing(pointcut="execution(* *..NewlecCalculator.div(..))",
			throwing="e")
	public void errorHandler(JoinPoint joinPoint, Throwable e){
		System.out.println("오류가 ("+e.getMessage()+") 발생했습니다. ");
	}
	
	@Around("execution(* *..NewlecCalculator.add(..))")
	public Object logHandler(ProceedingJoinPoint joinPoint) {
	//long start = System.currentTimeMillis();
		
		StopWatch watch = new StopWatch();
		watch.start();
		/*-------------- injection --------------*/
	
		Object result = null; 
		
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*---------------------------------------*/
		watch.stop();
		long duration = watch.getTotalTimeMillis();
		
		String message = duration + "ms가 걸림";
		
		//long end = System.currentTimeMillis();
		//String message = (end - start) + "ms가  걸림";
		System.out.println(message);
		
		return result;
	}
	
}
