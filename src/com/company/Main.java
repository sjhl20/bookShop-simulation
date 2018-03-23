package com.company;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		System.out.println("Books seperated by , :");
		Scanner sc = new Scanner(System.in);
		
		List<String> booksTobuy = Arrays.asList(sc.nextLine().split(","));
		sc.close();
		
		BookShop shop = BookShop.getInstance();				
		
        shop.addBook(new Book("Moby Dick",new BigDecimal(15.20),1851));
        shop.addBook(new Book("The Terrible Privacy of Maxwell Sim",new BigDecimal(13.14),2010));
        shop.addBook(new Book("Still Life With Woodpecker",new BigDecimal(11.05),1980));
        shop.addBook(new Book("Sleeping Murder",new BigDecimal(10.24),1976));
        shop.addBook(new Book("Three Men in a Boat",new BigDecimal(12.87),1889));
        shop.addBook(new Book("The Time Machine",new BigDecimal(10.43),1895));
        shop.addBook(new Book("The Caves of Steel",new BigDecimal(8.12),1954));
        shop.addBook(new Book("Idle Thoughts of an Idle Fellow",new BigDecimal(7.32),1886));
        shop.addBook(new Book("A Christmas Carol",new BigDecimal(4.23),1843));
        shop.addBook(new Book("A Tale of Two Cities",new BigDecimal(6.32),1859));
        shop.addBook(new Book("Great Expectations",new BigDecimal(13.21),1861));
        
        //set default values
        shop.setTotalPriceDiscount(5); //5% rate
        shop.setBookPublishedDiscount(10); //10% rate 
        shop.setDiscountYearThreshold(2000);	
        shop.setDiscountPriceThreshold(30);
        
        List<String> filteredList = new ArrayList<String>();
        
        //check if the ordered book exists
        for(String b:booksTobuy){
        	if(shop.bookExist(b)==true){
        		System.out.println(b + " exist.");
        		filteredList.add(b);
        	}else{
        		System.out.println(b + " doesn't exist.");
        	}
        		
        }		
        System.out.println("£"+shop.buy(filteredList).toString());
	}

}
