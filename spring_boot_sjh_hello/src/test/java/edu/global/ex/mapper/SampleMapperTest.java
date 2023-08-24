package edu.global.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class SampleMapperTest {
	
	@Autowired//주입
	private DataSource ds; //커넥션 풀=서버쪽에 있는 Connection객체
	
	@Autowired
	private SampleMapper sampleMapper;
	
	@Test
	void testDatasource() {
	System.out.println("DS="+ds);
	}
	
	@Test
	void testGetTime() {
	System.out.println(sampleMapper.getTime());
	
	}
	

}
