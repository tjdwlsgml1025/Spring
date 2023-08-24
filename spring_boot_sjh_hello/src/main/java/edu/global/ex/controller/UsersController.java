package edu.global.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.global.ex.vo.UserVO;

@Controller
@RequestMapping("/user/*")
public class UsersController {

	@GetMapping("/login") // user/login을 치게되면 login.jsp열어줌//url의 경로
	public String login() {
		return "/user/login"; // jsp의 경로
	}

	@PostMapping("/confirm")
	public String confirm(UserVO userVO) {
		String id = userVO.getId();

		if (id.equals("abc")) {
			return "redirect:loginOK";
		}
		return "redirect:loginFail";
	}

	@GetMapping("/loginOK")
	public String loginOK() {
		return "/user/loginOK";
	}

	@GetMapping("/loginFail")
	public String loginFail() {
		return "/user/loginFail";
	}

}