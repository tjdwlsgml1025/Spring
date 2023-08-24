package edu.global.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.global.ex.mapper.EmpMapper;
import edu.global.ex.vo.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired //주입
	private EmpMapper empMapper;

	@Override
	public List<EmpVO> getList() {

		return empMapper.getList(); //비즈니스 로직
	}

}
