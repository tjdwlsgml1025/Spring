package edu.global.ex.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BoardMapperTest {

   @Autowired
   private BoardMapper boardMapper;
   
   @Test
   void testGetList() {
      boardMapper.getList();
   }

}