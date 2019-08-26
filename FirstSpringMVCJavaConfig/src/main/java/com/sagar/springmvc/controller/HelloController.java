package com.sagar.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
	@GetMapping(path = {"/home"})
	public String homeJsp() {
		return "home";
	}
	
	
}
