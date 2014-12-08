package com.codurance.solid.discountCalculators;

import com.codurance.solid.Books;

import java.util.ArrayList;

public class BookDiscountCalculator implements DiscountCalculator {

	private ArrayList<DiscountCalculator> discountCalculators;

	public BookDiscountCalculator() {
		discountCalculators = new ArrayList<>();
		discountCalculators.add(new ITBooksDiscountCalculator());
		discountCalculators.add(new TravelBooksDiscountCalculator());
		discountCalculators.add(new FantasyBookDiscountCalculator());
		discountCalculators.add(new CookingBookDiscountCalculator());
	}

	@Override
	public double calculate(Books books) {
		return discountCalculators.stream()
												.map(discountCalculator -> discountCalculator.calculate(books))
												.reduce(0.0, (p1,p2) -> p1 + p2);
	}
}
