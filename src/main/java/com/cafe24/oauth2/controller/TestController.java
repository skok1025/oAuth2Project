package com.cafe24.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class TestController {
	
	@ResponseBody
	@GetMapping("/data")
	public String getData() {
		return "data";
	}

}
