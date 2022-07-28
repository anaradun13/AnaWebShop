package com.ana.webshop.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author ana.radun
 */

@Entity
@Table(name = "book")
public class Book implements Serializable {

	private static final long serialVersionUID = -1797116970630360870L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "type")
	private int type;
	@Column(name = "title")
	private String title;
	@Column(name = "price")
	private double price;
	@Column(name = "level")
	private String level;
	@Column(name = "tags")
	private String tags;
	@Column(name = "numberOfPages")
	private int numberOfPages;
	@Column(name = "publishingDate")
	private Date publishingDate;
	@Column(name = "introduction")
	private String introduction; // TODO ?
	@Column(name = "autors")
	private String autors;
	@Column(name = "image")
	private String image;
	@Column(name = "quantity")
	private Integer quantity;

	public Book() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Date getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAutors() {
		return autors;
	}

	public void setAutors(String autors) {
		this.autors = autors;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}