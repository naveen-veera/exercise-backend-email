package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmailModel {
	
	@Id
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="messgae")
	private String body;
	
	@Column(name="recived_on")
	private String date;
	
	@Column(name="sender_Id")
	private String sender;
	
	public EmailModel() {
		super();
	}

	public EmailModel(int id, String title, String body, String date, String sender) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.date = date;
		this.sender = sender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String string) {
		this.date = string;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Override
	public String toString() {
		return "EmailModel [id=" + id + ", title=" + title + ", body=" + body + ", date=" + date + ", sender=" + sender
				+ "]";
	}
	
}
