package com.codurance.solid.discountCalculators;

import com.codurance.solid.Books;

import static com.codurance.solid.BookType.IT;

public class ITBooksDiscountCalculator implements DiscountCalculator {

	private static final double THREE_OR_MORE_DISCOUNT = 0.7;
	private static final double DEFAULT_DISCOUNT = 0.9;

	private double discount = DEFAULT_DISCOUNT;

	@Override
	public double calculate(Books books) {
		if (books.numberOf(IT) > 2) {
			discount = THREE_OR_MORE_DISCOUNT;
		}
		return books.priceOfAll(IT) * discount;
	}
}
