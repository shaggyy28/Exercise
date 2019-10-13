package com.sagar.test.service;

import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sagar.common.AppLogger;
import com.sagar.test.dao.PersonDao;
import com.sagar.test.vo.PersonVo;

import static org.easymock.EasyMock.*;
import org.easymock.*;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfigTest.class})
@ActiveProfiles("test")
public class HelloServiceTest implements ApplicationContextAware{
	
	@Autowired
	private HelloService helloService;	
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Test
	public void getFullNameTest(){
		AppLogger.info(helloService.getFullName());
	}
	
	@Configuration
	static class AppConfigStatic{
		@Bean
		public PersonDao getPersonDao() {
			PersonDao personDaoMock = mock(PersonDao.class);
			expect(personDaoMock.getPerson())
					.andReturn(new PersonVo("Abhijeet", "Shinde"));
			replay(personDaoMock);
			return personDaoMock;
		}
		
		@Bean
		public HelloService getHelloService() {
			return new HelloService();
		}
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		
	}
	
	
}
