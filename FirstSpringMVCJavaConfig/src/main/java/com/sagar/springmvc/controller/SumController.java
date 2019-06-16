package com.sagar.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SumController {
	
	@ResponseBody
	@RequestMapping("/sum")
	public String sum() {
		int a = 1, b =1;
		return String.valueOf(a + b);
	}
}
