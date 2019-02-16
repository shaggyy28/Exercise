package com.sagar.exercise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
//@Configuration
public class ApplicationMainTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context 
								= new AnnotationConfigApplicationContext(ApplicationMainTest.class);
		
		String name = context.getBean(Service.class).getPrintableName();
		System.out.println(name);
		
		context.close();
	}
	
}
