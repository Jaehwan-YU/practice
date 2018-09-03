package com.newlecture.aop.spring;

import org.springframework.aop.ThrowsAdvice;

public class ErrorHandler implements ThrowsAdvice{
	
	//오류를 처리하는 코드 작성
	//target에서 메소드를 호출하다가.
	//어떤 예외가 발생 할 수 있는데
	//그 예외를 여기서 받아서 처리함
	//즉. 예외 처리하는 로직의 집중화 장소임.
	public void afterThrowing(ArithmeticException e) throws Throwable{
		System.out.println("분모가 0입니다.");
	}

}
