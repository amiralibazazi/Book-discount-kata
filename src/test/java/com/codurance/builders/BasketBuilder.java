package com.codurance.builders;

import com.codurance.solid.Basket;
import com.codurance.solid.Book;
import com.codurance.solid.discountCalculators.BookDiscountCalculator;

public class BasketBuilder {

//	private BookDiscountCalculator bookDiscountCalculator;
	private Book[] books = new Book[] {};

	public static BasketBuilder aBasket() {
		return new BasketBuilder();
	}

//	public BasketBuilder thatUses(BookDiscountCalculator bookDiscountCalculator) {
//		this.bookDiscountCalculator = bookDiscountCalculator;
//		return this;
//	}

	public BasketBuilder with(Book... books) {
		this.books = books;
		return this;
	}

	public Basket buildWith(BookDiscountCalculator bookDiscountCalculator) {
		Basket basket = new Basket(bookDiscountCalculator);
		addBooksTo(basket);
		return basket;
	}

	private void addBooksTo(Basket basket) {
		for (Book book : books) {
			basket.add(book);
		}
	}
}
