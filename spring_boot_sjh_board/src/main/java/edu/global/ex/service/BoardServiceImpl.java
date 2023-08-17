package edu.global.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.global.ex.mapper.BoardMapper;
import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired // 주입
	private BoardMapper boardMapper;

	// 글전체목록
	@Override // iOC컨테이너에 넣으라는얘기
	public List<BoardVO> getList() {
		log.info("getList()..");

		return boardMapper.getList();
	}

	// 글보기
	@Override // iOC컨테이너에 넣으라는얘기
	public BoardVO read(int bid) {
		log.info("read()..");

		return boardMapper.read(bid); // 매퍼에서 받아와
	}

	// 글 수정

	@Override
	public int modify(BoardVO board) {
		log.info("modify()..");

		return boardMapper.update(board); // 매퍼에서 넘어온거 리턴
	}

	// 글 삭제
	@Override
	public int remove(BoardVO board) {
		log.info("remove()..");

		return boardMapper.delete(board);// 매퍼의 메서드이름은 쿼리문에 비슷하게짓고, 서비스의 함수명은 기능에가깝게지음
	}

	// 글 작성
	@Override
	public void register(BoardVO board) {

		log.info("register()..");
		boardMapper.insert(board); // 매퍼의 메서드이름은 쿼리문에 비슷하게짓고, 서비스의 함수명은 기능에가깝게지음
	}
	
	//일련의 작업단위=트랜잭션 /두개이상로직인 곳에 넣고최대한 컨트롤러말고 서비스에 넣기
	@Transactional //둘중 하나가 오류날때 DB를 이전사항으로 rollback할수있게 
	@Override
	public void registerReply(BoardVO board) {
		log.info("registerReply()..");
		
		 boardMapper.updateShape(board);//답글의 세로 위치를 먼저 잡아준 후
	     boardMapper.insertReply(board);//답글을 등록한다.rd);
		
	}

	//페이징관련
	@Override
	public int getTotal() {		
		return boardMapper.getTotalCount();
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		return boardMapper.getListWithPaging(cri);
	}
	



}
