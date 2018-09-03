package com.newlecture.aop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.aop.spring.Calculator;

public class Program {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/newlecture/aop/spring/spring-context.xml");
		
		//스프링이 원본 객체(target)를 줄지 아니면 프록시를 줄지 여기 코드에서는 알 수 없음.
		Calculator cal = (Calculator) context.getBean("cal");
		
		int result = cal.add(3, 5);
		
		System.out.println("3+5 : " + result);
	}
}
