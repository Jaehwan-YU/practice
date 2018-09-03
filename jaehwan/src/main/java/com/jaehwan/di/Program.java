package com.jaehwan.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.di.entity.Exam;
import com.newlecture.di.ui.ExamConsole;
import com.newlecture.di.ui.FlowExamConsole;

public class Program {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/jaehwan/di/spring-context.xml");
		ExamConsole console = (ExamConsole) context.getBean("onsole");
		console.print();
		
	}
	
}
