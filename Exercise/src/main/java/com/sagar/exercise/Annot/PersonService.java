package com.sagar.exercise.Annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PersonService {
	
	@Autowired
	@Qualifier(value="primary")
	PersonTableDao getCassandraPersonDaoImpl;

	public String getPrintableName() {
		Person person = getCassandraPersonDaoImpl.getPerson();
		return String.format("%s %s", person.getFirst(), person.getLast());
	}

}
