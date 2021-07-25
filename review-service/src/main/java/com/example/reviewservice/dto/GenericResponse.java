package com.example.reviewservice.dto;

import java.util.List;


public class GenericResponse {

	private String status;
	private Integer code;
	private List<String> messages;
	private Object data;
	
	
	public GenericResponse() {}
	
	public GenericResponse(String status, Integer code, List<String> messages, Object data) {
		super();
		this.status = status;
		this.code = code;
		this.messages = messages;
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
