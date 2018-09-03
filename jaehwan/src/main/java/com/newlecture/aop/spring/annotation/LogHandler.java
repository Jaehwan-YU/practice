package com.newlecture.aop.spring.annotation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LogHandler implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {

		//long start = System.currentTimeMillis();
		
		StopWatch watch = new StopWatch();
		watch.start();
		/*-------------- injection --------------*/
	
		Object result = method.proceed();
		
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
