package com.codurance.solid.discountCalculators;

import com.codurance.solid.Books;

import static com.codurance.solid.BookType.*;

public class TravelBooksDiscountCalculator implements DiscountCalculator {

	private static final double DEFAULT_DISCOUNT = 1;
	private static final double FOUR_OR_MORE_DISCOUNT = 0.6;

	private double discount = DEFAULT_DISCOUNT;

	@Override
	public double calculate(Books books) {
		if (books.numberOf(TRAVEL) > 3) {
			discount = FOUR_OR_MORE_DISCOUNT;
		}
		return books.priceOfAll(TRAVEL) * discount;
	}
}
