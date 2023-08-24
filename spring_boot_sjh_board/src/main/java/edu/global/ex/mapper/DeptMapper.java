package edu.global.ex.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.global.ex.vo.DeptVO;


@Mapper
public interface DeptMapper {

	//@Select("Select * from emp, dept where emp.deptno = dept.deptno") //조인
	public List<DeptVO> getDeptEmpList();
    
	
	
}