package com.spring.springbootcrudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.springbootcrudoperation.dto.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	public User findByUserName(String userName);
	
	@Query(value = "SELECT * FROM user where user_city=?1",nativeQuery = true)
	public User findUserByCity(String user_city);
	
}
