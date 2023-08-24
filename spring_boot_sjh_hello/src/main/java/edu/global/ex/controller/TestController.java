package edu.global.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	

	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/test2")
	public String test2() {
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3() {
		return "test3";
	}
}
