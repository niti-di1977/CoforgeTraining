package com.company.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.model.User;

@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public boolean findUser(String username, String password)
	{
		
		User u = jdbcTemplate.queryForObject("select * from users where username=? and password=?",
											new BeanPropertyRowMapper<>(User.class),username,password);
	  return u != null;
	}
}
