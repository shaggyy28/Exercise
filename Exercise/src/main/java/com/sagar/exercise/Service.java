package com.sagar.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
	
	@Autowired
	PersonTableDao personTableDao11;

	public String getPrintableName() {
		Person person = personTableDao11.getPerson();
		return String.format("%s %s", person.getFirst(), person.getLast());
	}

}
