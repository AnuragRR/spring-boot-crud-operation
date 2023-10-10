package com.spring.springbootcrudoperation.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseStructure<T> {

	private int statusCode;
	private String statusMessage;
	private T data;
}
