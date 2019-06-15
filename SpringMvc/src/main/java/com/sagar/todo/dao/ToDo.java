package com.sagar.todo.dao;

import java.util.Date;

public class ToDo {
	private String event;
	private Status status;
	public ToDo(String event, Status status) {
		this.event = event;
		this.status = status;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return event + "\001" + status + "\n";
	}
	
	
}
