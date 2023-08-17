package edu.global.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.global.ex.page.Criteria;
import edu.global.ex.page.PageVO;
import edu.global.ex.service.BoardService;
import edu.global.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/*") // 보드밑에있는것들다타도록
public class BoardController {

	@Autowired // 주입(인터페이스를 구현한 구현체들을)
	private BoardService boardService;

	// 1.게시글목록보여줌
	@GetMapping("/list") // get메소드로 처리하도록
	public String list(Model model) {
		log.info("list() ..");

		model.addAttribute("boardList", boardService.getList());

		return "board/list"; // 이 뷰를 반환
	}

	// 2.게시글내용보여줌
	// http://localhost:8585/board/content_view?bid=20
	@GetMapping("/content_view") // get메소드로 처리하도록>url에 bid=?가있는것들
	public String content_view(BoardVO boardVO, Model model) { // 커맨드객체로 받아오니까알아서 bid가넘어옴
		log.info("content_view() ..");

		int bid = boardVO.getBid();
		model.addAttribute("content_view", boardService.read(bid));

		return "board/content_view"; // 이 뷰를 반환
	}

	// 3.게시글수정하기
	// http://localhost:8585/board/modify
	@PostMapping("/modify") // 수정은 post로 넘어가게
	public String modify(BoardVO boardVO, Model model) { // 커맨드객체로 받아오니까알아서 bid가넘어옴
		log.info("modify() ..");

		int rn = boardService.modify(boardVO);

		log.info("modify()..result number::" + rn);

		return "redirect:list"; // 수정끝나면 user로 하여금 다시 @GEtmapping(/list)부분 치고들어오게끔연결
	}

	// 4.게시글삭제
	// http://localhost:8585/board/delete?bid=20
	@GetMapping("/delete")
	public String delete(BoardVO boardVO) { // 커맨드객체로 받아오니까알아서 bid가넘어옴
		log.info("delete()");

		int rn = boardService.remove(boardVO);

		log.info("delete() ..result number::\" + rn");

		return "redirect:list";
	}

	// 5.글작성뷰
	// http://localhost:8585/board/write_view
	@GetMapping("/write_view")
	public String write_view() {
		log.info("write_view()..");

		return "/board/write_view";
	}

	// 6.글작성
	// http://localhost:8585/board/write
	@PostMapping("/write")
	public String write(BoardVO boardVO) {
		log.info("write..");

		boardService.register(boardVO);

		return "redirect:list";
	}

	// 7.답변뷰
	// http://localhost:8585/board/reply_view?bid=?
	@GetMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model) {
		log.info("reply_view..");

		// reply_view라는 이름으로 서비스에서 리드함수를 얻어온다(해당글받아옴)이때 bid는 글번호임
		model.addAttribute("reply_view", boardService.read(boardVO.getBid()));

		return "/board/reply_view";
	}

	// 8.답변작성뷰
	// http://localhost:8585/board/reply
	@PostMapping("/reply")
	public String reply(BoardVO boardVO) {
		log.info("reply..");

		boardService.registerReply(boardVO);

		return "redirect:list";
	}

	// 9.페이징
	@GetMapping("/list2") // get메소드로 처리하도록
	public String list2(Criteria cri, Model model) {
		log.info("list2() ..");
		log.info("list2() criteria값 확인" + cri);

		model.addAttribute("boardList", boardService.getListWithPaging(cri)); //글10개 가져오는 부분
		
		int total = boardService.getTotal();
		log.info("list2() 게시판 전체 갯수;"+total);
		
		model.addAttribute("pageMaker",new PageVO(cri,total)); //페이지버튼 그리기 위한 정보들
				
		return "board/list2"; 
	}

}