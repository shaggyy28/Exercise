package com.sagar.exercise.xml;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ApplicationMainTest {

	public static void main(String[] args) {
		
		GenericApplicationContext context
		   							= new GenericApplicationContext();
//		ClassPathXmlApplicationContext context 
//								= new ClassPathXmlApplicationContext("services.xml");
		new XmlBeanDefinitionReader(context).loadBeanDefinitions("services.xml");
		context.refresh();
		String name = context.getBean(PersonService.class).getPrintableName();
		System.out.println(name);
		
		context.close();
	}
	
	public static PersonTableDao getCassandraPersonDaoImpl(){
		return new PersonTableDao() {
			
			@Override
			public Person getPerson() {
				System.out.println("cassandra");
				return new Person("sagar", "Ingale");
			}
		};
	}
}
