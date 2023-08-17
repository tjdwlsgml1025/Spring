package edu.global.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController{
	
	@GetMapping("/")
	public String home() {
		return "home"; //home.jsp로 가도록
	}
	

	@GetMapping("/user/userHome")
	public void userHome() {	//void설정!
		log.info("userHome() ..");
		//return "home"; //return값에 user/userHome쓰기귀찮으니까void로설정함 /URL 경로가 곧 메소드 이름이 됨
	}
	
	@GetMapping("/admin/adminHome")
	public void adminHome() {	
		log.info("adminHome() ..");
		//return "home"; 
	}
	
	
}
