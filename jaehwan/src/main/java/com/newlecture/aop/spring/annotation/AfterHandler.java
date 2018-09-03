package com.newlecture.aop.spring.annotation;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterHandler implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		
		int result = (Integer)returnValue;
		
		if(result >= 5) 
			System.out.println("와! 값이 5보다 크다!");
		
	}

}
