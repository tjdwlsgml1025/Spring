package edu.global.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.global.ex.vo.EmpVO;

@Mapper //마이바티스를 위한
public interface EmpMapper { //인터페이스
	
	@Select("select * from emp") //필요한sql문작성
	public List<EmpVO> getList();
}
