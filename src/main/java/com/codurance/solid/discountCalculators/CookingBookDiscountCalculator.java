package com.codurance.solid.discountCalculators;

import com.codurance.solid.Books;

import static com.codurance.solid.BookType.*;

public class CookingBookDiscountCalculator implements DiscountCalculator{
	private static final double DEFAULT_DISCOUNT = 1;
	private double discount = DEFAULT_DISCOUNT;

	@Override
	public double calculate(Books books) {
		return books.priceOfAll(COOKING) * discount;
	}
}
