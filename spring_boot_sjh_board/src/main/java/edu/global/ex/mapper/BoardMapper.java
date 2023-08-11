package edu.global.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.global.ex.vo.BoardVO;

@Mapper //마이바티스용 매퍼임을 알려줌
public interface BoardMapper{
	
	public List<BoardVO>getList(); 	
	BoardVO read(int bid); //게시글내용보기 (파라미터는 url 넘어오는 bid값을 의미 )
	int update(BoardVO board); //글 수정(객체를 넘기고 있음)
	int delete(BoardVO board);
	public int remove(BoardVO board); //게시글 삭제
	public void insert(BoardVO board);
	public void insertReply(BoardVO board);
	public void updateShape(BoardVO board);
	
	
}
