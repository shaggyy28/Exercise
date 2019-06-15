package com.sagar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(path = "/todo")
@Controller
public class Hello {
	
	@GetMapping(value = "/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
	@GetMapping(value = "/world")
	@ResponseBody
	public String world() {
		return "world";
	}
	
}
