package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class BookShop {
	
	public static BookShop instance = null;
	
	private List<Book> bookList;
	private BigDecimal totalPriceDiscount;
	private BigDecimal bookPublishedDiscount;
	private int discountYearThreshold;
	private BigDecimal discountPriceThreshold;
	
	private BookShop(){
		bookList = new ArrayList();
		totalPriceDiscount = new BigDecimal(0);
		bookPublishedDiscount = new BigDecimal(0);
		discountYearThreshold = 0;
		discountPriceThreshold = new BigDecimal(0);
	}
	
	//instance is similar to object
	//so if instance of BookShop is already created then don't create instance again
	//but it the object for Bookshop has not been created(i.e. null) then create a new instance for the BookShop
	//so only ONE BookShop exists
	public static BookShop getInstance(){
		if (instance == null){
			instance = new BookShop();
		}
		return instance;
	}
    
	/**
	 * check if the book exists on BookShop
	 * @param bookTitle
	 * @return boolean value
	 */
	public boolean bookExist(String bookTitle){
		for(Book b:bookList){
			if (b.getTitle().replaceAll(" ", "").equalsIgnoreCase(bookTitle.trim().replaceAll(" ", ""))){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Calculate the price of ordered books with available discount
	 * @param buyList
	 * @return
	 */
	public BigDecimal buy(List<String> buyList){
		
		BigDecimal totalPrice = new BigDecimal(0);
		
		for(String b : buyList){
			for (Book book: bookList){
				//for each book from buy list check if it exists
				if(book.getTitle().replaceAll(" ", "").equalsIgnoreCase(b.trim().replaceAll(" ", ""))){
					//if published date is greater than the set 'discountYearThreshold' (for now is 2000 year)
					if(book.getPublishedDate() > discountYearThreshold){
						totalPrice = totalPrice.add(discountPrice(book.getPrice(),bookPublishedDiscount));
					}
					else{
						totalPrice = totalPrice.add(book.getPrice());
					}
				}
			}
		}
		if (totalPrice.compareTo(discountPriceThreshold)==1){
			totalPrice = discountPrice(totalPrice,totalPriceDiscount);
		}
		
		return totalPrice.setScale(2, RoundingMode.DOWN);
	}
	
	/**
	 * Calculate final price after discount
	 * @param price
	 * @param discount
	 * @return price after discount
	 */
	public BigDecimal discountPrice(BigDecimal price, BigDecimal discount){
		price = price.subtract(price.multiply(discount));
		return price;
	}
	
	public List<Book> getBookList(){
		return bookList;
	}
	
	public void addBook(Book book){
		bookList.add(book);
	}
	
	public void setDiscountYearThreshold(int year){
		this.discountYearThreshold = year;
	}
	
	public void setDiscountPriceThreshold(int price){
		this.discountPriceThreshold = new BigDecimal(price);
	}
	
	public void setTotalPriceDiscount(int rate){
		this.totalPriceDiscount = (new BigDecimal(rate).divide(new BigDecimal(100)));
	}
	
	public void setBookPublishedDiscount(int rate){
		this.bookPublishedDiscount = (new BigDecimal(rate).divide(new BigDecimal(100)));
	}
}
