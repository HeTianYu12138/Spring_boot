package com.example.demo.model;

import java.sql.Time;


public class ToDo {
    private final long id;
    private String content;
    private Time createTime;
    public Time getCreateTime() {
		return createTime;
	}

	public ToDo(long id, String content) {
        this.id = id;
        this.content = content;
        this.createTime = new Time(new java.util.Date().getTime());
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
