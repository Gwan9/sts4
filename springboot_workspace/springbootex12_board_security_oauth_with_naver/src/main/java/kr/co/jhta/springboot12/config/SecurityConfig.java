package kr.co.jhta.springboot12.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.ProviderManagerBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.co.jhta.springboot12.service.CustomerOAuth2UseretailService;

// spring security : 스프링 기반의 애플리케이션 보안을 담당하는 프레임워크
// fillter chain 방식사용

// 설정파일 빈을 등록
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource datasource;
	// 패스워드 암호화
	// BCryptPasswordEncoder
	@Autowired
	PasswordEncoder passwordEncoder;
	// BCrypt 라는 해쉬 함수를 이용해서 패스워드를 암호화하는 목적으로 설계된 클래스
	
	@Autowired
	CustomerOAuth2UseretailService userDetailService;
	
	
	
	
	// 임시 비번으로 로그인 -> 불편
	// 새로운 사용자정보를 추가
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// 사용자 ID : user1
		// password : aaa
		
//		InMemoryUserDetailsManagerConfigurer iudm = auth.inMemoryAuthentication();
	
//		UserDetailsBuilder udb = iudm.withUser("user1");
	
//		udb = udb.password("$2a$10$02.R0fNAD5A0bC1cQVlS.uhgPXmBJHNtZMaztyKxDykBL6frurXMC");

//		udb = udb.roles("USER");
		
//		auth.inMemoryAuthentication()
//			.withUser("user1")
//			.password("$2a$10$02.R0fNAD5A0bC1cQVlS.uhgPXmBJHNtZMaztyKxDykBL6frurXMC")
//			.roles("ADMIN");
		String  usernameQuery = "SELECT id as username, pw as password, enabled from member where id = ?";
		//String authQuery = "SELECT a.id as username, b.role as authority from member a, member_role b WHERE a.id=b.id and a.id = ? ";
				
		StringBuffer authQuery = new StringBuffer();
		authQuery.append("SELECT a.id as username, b.role as authority ");
		authQuery.append("from member a, member_role b ");
		authQuery.append("WHERE a.id=b.id and a.id = ? ");
			
		auth.jdbcAuthentication()	
			.dataSource(datasource)
			.usersByUsernameQuery(usernameQuery)
			.authoritiesByUsernameQuery(authQuery.toString())
			.passwordEncoder(passwordEncoder);
	}
	// 인가가 필요한 리소스 설정하기
	
	//HttpSecurity -> configure
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.authorizeHttpRequests()
			// 인증된 사람만 접근가능
			.antMatchers("/board/**").authenticated()
			// USER Role만 접근가능
			.antMatchers("/member/**").hasRole("USER")
			// ADMIN Role만 접근가능
			.antMatchers("/admin/**").hasRole("ADMIN")
			// 그 외 모든 요청 허용
			.anyRequest().permitAll()
			.and() // 추가
				.formLogin() // form 기반의 로그인 경우
				.loginPage("/clogin")
				.usernameParameter("username") // 로그인 폼에서 id 가져올 값의 Parameter name
				.passwordParameter("password") // 로그인 폼에서 password 가져올 값의 Parameter name
				.loginProcessingUrl("/login") // 로그인 처리할 URL
				.defaultSuccessUrl("/") // 로그인 성공하면 "/"로 이동
				.failureUrl("/clogin?error=true") // 로그인 실패하면 
			.and()
				.logout()
				.logoutUrl("/logout")
			.and()
				.oauth2Login()
				.loginPage("/clogin").permitAll()
				.userInfoEndpoint()// Oauth2 로그인 사용자 정보를 가져오는 설저을 담당
				.userService(userDetailService); // 소셜 로그인 성공시 진행 할 OAuth2UserService 인터페이스를 구현한 객체를 등록
			
			// 즉 사용자 정보를 가져온 사ㅏㅇ태에서 추가 진행하고자 하는 기능을 구현
//				.logoutSuccessUrl("/"); //로그아웃 성공시 "/"로 이동
			//access("hasRole('USER') or hasRole('ADUMIN')");
		
			
		
		
//		http.authorizeHttpRequests()
//			// 인증된 사람만 접근가능
//			.antMatchers("/board/**").authenticated()
//			// USER Role만 접근가능
//			.antMatchers("/member/**").hasRole("USER")
//			// ADMIN Role만 접근가능
//			.antMatchers("/admin").hasRole("ADMIN")
//			.anyRequest().permitAll()
//			.and()
//			.formLogin()
//			.loginPage("/login")
//			.permitAll();
		}
}
