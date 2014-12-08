package com.codurance.solid;

import com.codurance.solid.discountCalculators.*;

public class Basket {

	private Books books = new Books();
	private BookDiscountCalculator bookDiscountCalculator;

	public Basket(BookDiscountCalculator bookDiscountCalculator) {
		this.bookDiscountCalculator = bookDiscountCalculator;
	}

	public void add(Book item) {
		books.add(item);
	}

	public Books books() {
		return books;
	}

	public double priceWithDiscount() {
		return bookDiscountCalculator.calculate(books);
	}

	public double fullPrice() {
		return books.priceOfAll(BookType.values());
	}
}
