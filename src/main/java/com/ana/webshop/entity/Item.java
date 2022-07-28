package com.ana.webshop.entity;

import java.io.Serializable;

/**
 *
 * @author ana.radun
 */

public class Item  implements Serializable {

	private static final long serialVersionUID = -2134922103339875281L;
	private long recordId;
	private long userId;
	private long bookId;
	private String title;
	private String publishingDate;
	private String numberOfPages;
	private double price;
	private String image;
	private String paymentTime;

	public Item() {

	}

	public Item(long userId, long bookId, String title, String date, String numberOfPages, double price, String image, String time,
			long rid) {
		this.userId = userId;
		this.bookId = bookId;
		this.title = title;
		this.publishingDate = date;
		this.numberOfPages = numberOfPages;
		this.price = price;
		this.image = image;
		this.paymentTime = time;
		this.recordId = rid;
	}

	public long getRecordId() {
		return recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
	}

	public String getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(String numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
