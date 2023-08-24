package edu.global.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.EmpDeptVO;
import edu.global.ex.vo.UserVO;

@Mapper // 마이바티스용 매퍼임을 알려줌
public interface EmpMapper {

	List<EmpDeptVO> getEmpDeptList();

}