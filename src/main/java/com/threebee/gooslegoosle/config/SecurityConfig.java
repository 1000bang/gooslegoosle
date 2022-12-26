package com.threebee.gooslegoosle.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@SuppressWarnings("deprecation") //디플리케이션의 경고를 무시함  
@Configuration // Ioc 관
@EnableWebSecurity  // security filter 로 등록 (필터 커스텀)  
@EnableGlobalMethodSecurity(prePostEnabled = true)// 특정 주소로 접근하면 권한 및 인증 처리를 미리체크함 
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Bean
	public BCryptPasswordEncoder bcencodePwd() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//    public CustomAuthFailureHandler customAuthFailureHandler(){
//        return new CustomAuthFailureHandler();
//    }
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http
		.authorizeHttpRequests()
			.antMatchers("/auth/**", "/" , "/js/**", "/image/**", "/css/**") 
			.permitAll()
			.anyRequest()
			.authenticated()
		.and()
		.formLogin()
		.loginPage("/auth/login_form")
		.loginProcessingUrl("/auth/loginProc")
		//.failureHandler(customAuthFailureHandler())// 이 요청이 오면 캐치해라 
		.defaultSuccessUrl("/");
}
	
	
	
	
}
