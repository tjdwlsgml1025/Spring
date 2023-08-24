package edu.global.ex.mapper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.global.ex.vo.UserVO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@SpringBootTest
class UserMapperTest {

   @Autowired
   private UserMapper userMapper;
   
   //UserVO(username=admin, password=admin, enabled=1, 
   //authList=[AuthVO(username=admin, authority=ROLE_ADMIN), 
   //AuthVO(username=admin, authority=ROLE_MANAGER)])

   @Test
   void testGetList() {
      UserVO user = userMapper.getUser("admin");
      System.out.println(user);      
   }
   
   
   //@Insert("insert into users(username,password,enabled) values(#{username},#{password},#{enabled})")
   //public int insertUser(UserVO userVO);

   //@Insert("insert into AUTHORITIES (username,AUTHORITY) values(#{username},'ROLE_USER')")
   //public void insertAuthorities(UserVO UserVO);

   
   @Test
   void testInsertUser() {
      UserVO user = new UserVO();
      user.setUsername("user2");
      user.setPassword(new BCryptPasswordEncoder().encode("user2"));
      user.setEnabled(1);
      
      userMapper.insertUser(user);
      userMapper.insertAuthorities(user);
   }
}
