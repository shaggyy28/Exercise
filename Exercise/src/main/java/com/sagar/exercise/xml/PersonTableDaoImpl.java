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
