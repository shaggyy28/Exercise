package com.sagar.exercise.xml;



class PersonTableMySqlDaoImpl implements PersonTableDao {
	@Override
	public Person getPerson() {
		System.out.println("sql");
		return new Person("sagar", "Ingale");
	}
}

class PersonTableMongoDaoImpl implements PersonTableDao{
	@Override
	public Person getPerson() {
		System.out.println("mongo");
		return new Person("sagar", "Ingale");
	}
}

class Person{
	private String first;
	private String last;
	public Person(String first, String last) {
		super();
		this.first = first;
		this.last = last;
	}
	public String getFirst() {
		return first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	
	
}
