package com.company;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BookShopTest {

	@org.junit.Test
	public void testBuy() throws Exception {
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

        shop.setTotalPriceDiscount(5);
        shop.setBookPublishedDiscount(10);
        shop.setDiscountYearThreshold(2000);
        shop.setDiscountPriceThreshold(30);
        
        List<String> booksToBuyTest1 = new ArrayList();
        booksToBuyTest1.add("The Terrible Privacy of Maxwell Sim");
        booksToBuyTest1.add("Three Men in a Boat");
        assertEquals(new BigDecimal(24.69 ).setScale(2,RoundingMode.DOWN),shop.buy(booksToBuyTest1));
        
        List<String> booksToBuyTest2 = new ArrayList();
        booksToBuyTest2.add("Still Life with Woodpecker");
        booksToBuyTest2.add("Three Men in a Boat");
        booksToBuyTest2.add("Great Expectations");
        assertEquals(new BigDecimal(35.27).setScale(2,RoundingMode.DOWN),shop.buy(booksToBuyTest2));

        List<String> booksToBuyTest3 = new ArrayList();
        booksToBuyTest3.add("The Terrible Privacy of Maxwell Sim");
        booksToBuyTest3.add("Three Men in a Boat");
        booksToBuyTest3.add("Great Expectations");
        assertEquals(new BigDecimal(36.01).setScale(2,RoundingMode.CEILING),shop.buy(booksToBuyTest3));
	}

	@org.junit.Test
    public void testIfBookExist() throws Exception {
        BookShop shop  = BookShop.getInstance();

        List<String> booksToBuyTest1 = new ArrayList();
        booksToBuyTest1.add("The Terrible Privacy of Maxwell Sim");
        booksToBuyTest1.add("Three Men in a Boat");

        for(String book:booksToBuyTest1){
            assertFalse(shop.bookExist(book));
        }
    }

}
