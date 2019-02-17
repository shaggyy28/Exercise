package com.sagar.exercise;

import java.util.Arrays;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.lang.NonNull;

import com.sagar.exercise.xml.Person;
import com.sagar.exercise.xml.PersonService;
import com.sagar.exercise.xml.PersonTableDao;

@Configuration
public class XmlApplication {
	@NonNull
	private StringBuffer name;// = new StringBuffer("sagar");
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext annoCon
									= new AnnotationConfigApplicationContext(XmlApplication.class);
		GenericApplicationContext context
		   							= new GenericApplicationContext(annoCon);
//		ClassPathXmlApplicationContext context 
//								= new ClassPathXmlApplicationContext("services.xml");
		new XmlBeanDefinitionReader(context).loadBeanDefinitions("constructor.xml");
		
		context.refresh();
//		String name = context.getBean(PersonService.class).getPrintableName();
		Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);
		StringBuffer name = (StringBuffer)context.getBean("name");
		System.out.println(name);
		long a = 12;
		context.close();
	}
	
	
	@Bean(name="name")
	public StringBuffer getName() {
		return name;
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
