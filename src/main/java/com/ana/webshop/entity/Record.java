package com.ana.webshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class Record implements Serializable {

    private static final long serialVersionUID = 7748477855476334145L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "userId")
	private long userId;
	@Column(name = "bookId")
	private long bookId;
	@Column(name = "isPaid")
	private String isPaid;
	@Column(name = "time")
	private long time;

	public Record() {
		super();
	}

	public Record(long userId, long bookId, String isPaid, long time) {
		this.userId = userId;
		this.bookId = bookId;
		this.isPaid = isPaid;
		this.time = time;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
