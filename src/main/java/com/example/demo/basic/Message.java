package com.example.demo.basic;

import lombok.Data;

@Data
public class Message {

	private int application;
	private String userId;
	private String timestamp;
	private String digest;

}
