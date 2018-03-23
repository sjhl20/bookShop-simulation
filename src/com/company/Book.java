
package com.company;

import java.math.BigDecimal;

public class Book {
	private String title;
	private BigDecimal price;
	private int year;
	
	public Book(){
		title = "";
		price = new BigDecimal(0);
		year = 0;	
	}
	
	/**
	 * Parametrised Constructor
	 * @param title
	 * @param price
	 * @param year   Book published year
	 */
	public Book(String title,BigDecimal price,int year){
		this.title = title;
		this.price = price;
		this.year = year;
	}
	
	/**
	 * Setter method for book title
	 * @param newTitle
	 */
	public void setTitle(String newTitle){
		this.title = newTitle;
	}
	
	/**
	 * Getter method for book title
	 * @return title
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Getter method for book price
	 * @param price
	 */
	public BigDecimal getPrice(){
		return price;
	}
	
	/**
	 * Getter method for book price
	 * @param price
	 */
	public int getPublishedDate(){
		return year;
	}
}
