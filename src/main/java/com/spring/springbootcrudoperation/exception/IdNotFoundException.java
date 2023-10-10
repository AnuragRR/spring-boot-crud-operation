package com.spring.springbootcrudoperation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor
public class IdNotFoundException extends Exception {

	
	public String msg;
}
