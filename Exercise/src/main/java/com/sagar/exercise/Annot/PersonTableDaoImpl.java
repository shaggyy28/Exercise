package com.sagar.exercise.Annot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
@Primary
class PersonTableMySqlDaoImpl implements PersonTableDao {
	@Override
	public Person getPerson() {
		System.out.println("sql");
		return new Person("sagar", "Ingale");
	}
}

@Repository
@Qualifier(value="primary")
class PersonTableMongoDaoImpl implements PersonTableDao{
	@Override
	public Person getPerson() {
		System.out.println("mongo");
		return new Person("sagar", "Ingale");
	}
}


