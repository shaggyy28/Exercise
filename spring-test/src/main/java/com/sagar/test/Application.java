package com.sagar.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sagar.common.AppLogger;
import com.sagar.test.service.HelloService;

@Configuration
@ComponentScan({"com.sagar.test.service", "com.sagar.test.dao"})
public class Application {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
		HelloService helloService = applicationContext.getBean(HelloService.class);
//		helloService.printHello();
		AppLogger.info(helloService.getFullName());
	}
}
