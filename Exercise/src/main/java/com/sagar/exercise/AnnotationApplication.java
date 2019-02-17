package com.sagar.exercise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sagar.exercise.Annot.Person;
import com.sagar.exercise.Annot.PersonService;
import com.sagar.exercise.Annot.PersonTableDao;

@ComponentScan
@Configuration
public class AnnotationApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context 
								= new AnnotationConfigApplicationContext(AnnotationApplication.class);
		getCassandraPersonDaoImpl();
		String name = context.getBean(PersonService.class).getPrintableName();
		System.out.println(name);
		
		context.close();
	}
	
	@Bean
//	@Primary
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
