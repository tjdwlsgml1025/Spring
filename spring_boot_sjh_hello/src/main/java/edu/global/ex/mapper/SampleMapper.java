package edu.global.ex.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SampleMapper { //인터페이스
	@Select("select sysdate from dual") //자식구현한게 이거임
	public String getTime();
}
