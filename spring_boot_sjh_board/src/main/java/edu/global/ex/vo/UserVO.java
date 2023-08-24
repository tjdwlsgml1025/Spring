package edu.global.ex.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



/*이름       널?       유형            
-------- -------- ------------- 
USERNAME NOT NULL VARCHAR2(50)  
PASSWORD NOT NULL VARCHAR2(100) 
ENABLED           CHAR(1)   
*/


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserVO{
	private String username;
	private String password;
	private int enabled;
	//DB에있는 테이블 받아오기 (유저1:권한N)위해 권한atuhVO를 리스트로 만든다.
	private List<AuthVO> authList;
	
	
	
	
}
