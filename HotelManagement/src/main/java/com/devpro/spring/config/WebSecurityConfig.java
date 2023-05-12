package com.devpro.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.devpro.spring.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
// giúp phân quyền cho người dùng
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private DataSource dataSource;
	
	//giúp mã hóa pw
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}
	
	// phân quyền cho người dùng
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		// ta có permitAll(): cho phép tất cả mọi người truy cập vào trang login("/") và trang logout
		
		http.authorizeRequests().antMatchers("/", "/logout").permitAll() // cho phép tất cả mọi người truy cập vào 2 địa chỉ này
		.and()
			.formLogin().usernameParameter("username").passwordParameter("pass") //lấy thông tin username, pass từ file login
				.loginPage("/login")
					.permitAll();
		// tất cả các trang còn lại thì yêu cầu kiểm tra phải đúng quyền thì mới cho phép truy cập
		http.authorizeRequests().antMatchers("/check-in").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/check-out").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/chamber").access("hasAnyRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/guests").access("hasAnyRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/order").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/service").access("hasAnyRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/employee").access("hasAnyRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/update-chamber/**").access("hasAnyRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/update-employee-info").access("hasAnyRole('ROLE_ADMIN')");
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
	}
	
	// triển khai lưu trữ mã thông báo đăng nhập liên tục dựa trên jdbc
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
}
