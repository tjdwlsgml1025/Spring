package edu.global.ex.config
;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration //@Component+설정
@EnableWebSecurity//스프링시큐리티필터가 스프링 필터체인에 등록됨 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	 @Override 
	   public void configure(WebSecurity web) throws Exception {
	      // web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	      web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	   }    //리소스파일들은 시큐리티세팅에서 관리하지 않도록
	
	 
	  @Override //테스트용 아디비번 설정
	   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	       auth.inMemoryAuthentication()
	               .withUser("user").password("{noop}user").roles("USER").and() //user아이디로 로그인하게되면user자격ㅈ얻음
	               .withUser("admin").password("{noop}admin").roles("ADMIN");
	   }
	  
	  @Override //권한인증 설정해주기
	   protected void configure(HttpSecurity http) throws Exception {
	      //우선 CSRF설정을 해제한다.Cross-Site Request Forgery 공격 방지 기능 비활성화
	      //초기 개발시만 해주는게 좋다.
	      http.csrf().disable();
	      
	      //시큐리티란? 인증과 권한
	      http.authorizeRequests() // 인증과 권한을 설정
	      .antMatchers("/user/**").hasAnyRole("USER")  // 경로 패턴을 지정,권한있는자만 접근가능하게//user아이디로 로그인하게되면user자격얻음
	      .antMatchers("/admin/**").hasAnyRole("ADMIN") //관리자페이지권한
	      .antMatchers("/**").permitAll(); //모든 경로에 대해 인증되지 않은 사용자도 접근을 허용 (모두에게)  
	      
	      http.formLogin(); //스프링 시큐리티에 있는 기본 로그인 폼을 사용하겠다는뜻
	   }
	  
	  
	  
}