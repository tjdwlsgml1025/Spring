package edu.global.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.global.ex.service.EmpService;
import lombok.extern.slf4j.Slf4j;

@Slf4j//log를 보기위해(시간나와)
@Controller //기능: 객체생성 = EmpController empController = new EmpController()
@RequestMapping("/emp/*")
public class EmpController {

	@Autowired
	private EmpService empService; //서비스를 가지고
	
	@GetMapping("/list")
	public String list(Model model) { //서비스의 해당 함수를 호출함
		
		log.info("list()...");
		
		model.addAttribute("emps",empService.getList()); //데이터정보받아옴
		
		return "emp/list"; //emp폴더만들고그밑에jsp파일넣어줘야함
	}

}