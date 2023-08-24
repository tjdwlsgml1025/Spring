package edu.global.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.global.ex.vo.CircleVO;
import edu.global.ex.vo.GradeVO;


@Controller
@RequestMapping("/board/*")
public class GradeController {
 
   //3.command 객체를 이용하는 방법
   //내부동작
   //MemberVO memberVO = new MemberVO();
   // memberVO.setId(request.getParameter("id"));
   
	/*
	 * @GetMapping("/input") public String input(GradeVO gradeVO, Model model) {
	 * 
	 * System.out.println(gradeVO);
	 * 
	 * return "board/grade"; }
	 */
   

   

   
}