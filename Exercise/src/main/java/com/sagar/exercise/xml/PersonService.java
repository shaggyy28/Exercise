package com.sagar.exercise.xml;

import java.beans.ConstructorProperties;

public class PersonService {
	
	PersonTableDao personTableMongoDao;
	PersonTableDao personTableMydqlDao;
	
//	public PersonService(PersonTableDao personTableMongoDao, PersonTableDao personTableMydqlDao) {
//		super();
//		System.out.println("******************constructor");
//		this.personTableMongoDao= personTableMongoDao;
//		this.personTableMydqlDao = personTableMydqlDao;
//	}
	
	public PersonService(int name, int last) {
		System.out.println(name + " " + last);
	}

	public String getPrintableName() {
		Person person = personTableMongoDao.getPerson();
		return String.format("%s %s", person.getFirst(), person.getLast());
	}

	public PersonTableDao getPersonTableMongoDao() {
		return personTableMongoDao;
	}

	public void setPersonTableMongoDao(PersonTableDao personTableMongoDao) {
		this.personTableMongoDao = personTableMongoDao;
	}

	public PersonTableDao getPersonTableMydqlDao() {
		return personTableMydqlDao;
	}

	public void setPersonTableMydqlDao(PersonTableDao personTableMydqlDao) {
		this.personTableMydqlDao = personTableMydqlDao;
	}
	
	

	
}
