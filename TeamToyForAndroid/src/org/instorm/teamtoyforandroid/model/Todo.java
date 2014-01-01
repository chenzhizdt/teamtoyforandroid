package org.instorm.teamtoyforandroid.model;

import java.util.Date;

public class Todo {
	private Date createTime;
	private String content;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Todo(Date createTime, String content) {
		super();
		this.createTime = createTime;
		this.content = content;
	}
}
