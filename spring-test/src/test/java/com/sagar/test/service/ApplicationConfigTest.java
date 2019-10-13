package com.sagar.test.service;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.BootstrapContext;
import org.springframework.test.context.CacheAwareContextLoaderDelegate;
import org.springframework.test.context.MergedContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestContextBootstrapper;
import org.springframework.test.context.TestExecutionListener;

import com.sagar.test.dao.PersonDao;
import com.sagar.test.vo.PersonVo;

import static org.easymock.EasyMock.*;

@Configuration
@Profile("test")
public class ApplicationConfigTest{
	
	@Bean
	public PersonDao getPersonDao() {
		PersonDao personDaoMock = mock(PersonDao.class);
		expect(personDaoMock.getPerson())
				.andReturn(new PersonVo("Sumit", "Singh"));
		replay(personDaoMock);
		return personDaoMock;
	}
	
	@Bean
	public HelloService getHelloService() {
		return new HelloService();
	}
	
}
