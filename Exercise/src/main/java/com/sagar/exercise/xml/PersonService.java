package com.sagar.exercise.xml;


public class PersonService {
	
	PersonTableDao personTableDao;

	public String getPrintableName() {
		Person person = personTableDao.getPerson();
		return String.format("%s %s", person.getFirst(), person.getLast());
	}

	public PersonTableDao getPersonTableDao() {
		return personTableDao;
	}

	public void setPersonTableDao(PersonTableDao personTableDao) {
		this.personTableDao = personTableDao;
	}
	
	
}
