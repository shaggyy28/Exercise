package com.sagar.test.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sagar.test.dao.PersonDao;
import com.sagar.test.vo.PersonVo;

@Component
public class HelloService {
	private final Logger LOGGER = Logger.getLogger("com.sagar.test");

	@Autowired
	private PersonDao personDao;

	public void printHello() {
		LOGGER.info("Hello World");
	}

	public String getFullName() {
		PersonVo personVo = personDao.getPerson();
		return personVo.getFirst() + " " + personVo.getLast();
	}
}
