package by.epam.first.entity;

import java.sql.Date;

public class Comment extends Entity {

	private long id;
	private String text;
	private Date date;
	private User user;
	
	public Comment(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
