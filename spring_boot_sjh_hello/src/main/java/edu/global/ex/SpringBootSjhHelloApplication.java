package edu.global.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@componentScam과 @EnableAutoConfiguration
//=@Controller @Service @Repository 세개등등등…을 스캔하라는 뜻
@SpringBootApplication 
public class SpringBootSjhHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSjhHelloApplication.class, args);
	}

}
