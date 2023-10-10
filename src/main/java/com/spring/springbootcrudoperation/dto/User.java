package com.spring.springbootcrudoperation.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

	@Id
	private int userId;
	private String userName;
	private long userPhone;
	private String userCity;
	
}
