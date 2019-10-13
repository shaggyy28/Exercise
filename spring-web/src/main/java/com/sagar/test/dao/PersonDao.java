package com.sagar.test.dao;

import org.springframework.stereotype.Repository;

import com.sagar.test.vo.PersonVo;

@Repository
public class PersonDao {
	
	public PersonVo getPerson() {
		return new PersonVo("sagar", "Ingale");
	}
}
