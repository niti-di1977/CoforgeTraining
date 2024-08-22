package com.hcl.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  //Http Security
{
		
	
	@Autowired
	DataSource ds;
	
	//handling the user accounts and assigning roles
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		PasswordEncoder pwe=getPasswordEncoder();
//		auth.inMemoryAuthentication()
//			.withUser("Ram")
//			.password(pwe.encode("Hcl123"))
//			.roles("owner")
//			.and()
//			.withUser("Ria")
//			.password(pwe.encode("Ria123"))
//			.roles("client")
//			.and()
//			.withUser("Lakhan")
//			.password(pwe.encode("hhh"))
//			.roles("admin");
		
		auth.jdbcAuthentication()
		.dataSource(ds)
		.withDefaultSchema()
		.withUser(User.withUsername("Ram")
				  .password(pwe.encode("Hcl123"))
		          .roles("owner")
				 )
		.withUser(User.withUsername("Ria")
				  .password(pwe.encode("Gl789"))
				  .roles("client")
				 )
		.withUser(User.withUsername("Lakhan")
				   .password(pwe.encode("hhh"))
				   .roles("admin")
				);

		
		
	//	auth.inMemoryAuthentication().withUser("Ram").password(pwe.encode("Hcl123")).roles("owner").and().withUser("Ria").password(pwe.encode("Gl789")).roles("client");


	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	//pattern//unblocking sites from login
	@Override
	public void configure(WebSecurity web) throws Exception {
		//to enable h2-console/swagger ui
		web.ignoring().antMatchers("/h2-console/**")
					  .antMatchers("/swagger-ui.html/**");   
	}

	//assign specific http method to specific roles
	@Override
	protected void configure(HttpSecurity http) throws Exception    //HTTP methods: GET POST PUT DELETE
	{
	   	http.csrf().disable().authorizeRequests()    //CROSS SITE REQUEST FORGERY
	   	.antMatchers("/add","/delete").hasRole("admin")  
	   	.antMatchers("/update").hasRole("owner")
	   	.antMatchers("/getAllProds").hasAnyRole("owner","client") //more than one role: hasAnyRole()
	   	.antMatchers("/")
	   	.permitAll()
	   	.and()
	   	.formLogin();
	   	
	}
	
	
	
}
