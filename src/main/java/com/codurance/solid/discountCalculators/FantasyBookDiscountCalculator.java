package com.codurance.solid.discountCalculators;

import com.codurance.solid.Books;

import static com.codurance.solid.BookType.*;

public class FantasyBookDiscountCalculator implements DiscountCalculator{
	private double DEFAULT_DISCOUNT = 1;
	private double TWO_OR_MORE_DISCOUNT = 0.8;

	private double discount = DEFAULT_DISCOUNT;

	@Override
	public double calculate(Books books) {
		if (books.numberOf(FANTASY) > 1) {
			discount = TWO_OR_MORE_DISCOUNT;
		}
		return books.priceOfAll(FANTASY) * discount;
	}
}
