package com.sagar.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sagar.test.service.HelloService;

@Controller
public class PersonController {
	
	@Autowired
	private HelloService helloService;
	
	@GetMapping("/person")
	@ResponseBody
	public String getPerson() {
		return helloService.getFullName();
	}
	
	
	@GetMapping("/person-json")
	public ResponseEntity<String> getPersonJson() {
		String fullName = "{ \"name\": \"" + helloService.getFullName() + "\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<String>(fullName, headers, HttpStatus.OK);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "/index.jsp";
	}
}
