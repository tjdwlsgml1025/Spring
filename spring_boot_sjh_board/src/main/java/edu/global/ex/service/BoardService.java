package edu.global.ex.service;

import java.util.List;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;

public interface BoardService{
	List<BoardVO> getList(); //리스트메소드(VO에있는요소들을 getList라는이름으로 리스트저장)
	BoardVO read(int bid); //글보기 메소드 
	int modify(BoardVO board); //글수정
	int remove(BoardVO boardVO); //글 삭제
	void register(BoardVO boardVO); //글작성
	void registerReply(BoardVO boardVO);//답글등록
	
	//페이징 처리함수
	public int getTotal();
	public List<BoardVO> getListWithPaging(Criteria cri);
	
}
