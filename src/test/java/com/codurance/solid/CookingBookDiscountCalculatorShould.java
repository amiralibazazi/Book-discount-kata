package com.codurance.solid;

import com.codurance.solid.discountCalculators.CookingBookDiscountCalculator;
import org.junit.Test;

import static com.codurance.builders.BookBuilder.*;
import static com.codurance.builders.BooksBuilder.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CookingBookDiscountCalculatorShould {

	@Test public void
	apply_no_discount_to_one_cooking_book() {
		Books books = books().containing(
															aCookingBook().costing(9.00).build())
														.build();

		double priceWithDiscount = new CookingBookDiscountCalculator().calculate(books);

		assertThat(priceWithDiscount, is(9.00));
	}

	@Test public void
	apply_no_discount_to_multiple_cooking_books() {
		Books books = books().containing(
															aCookingBook().costing(9.00).build(),
															aCookingBook().costing(8.00).build(),
															aCookingBook().costing(2.00).build())
														.build();


		double priceWithDiscount = new CookingBookDiscountCalculator().calculate(books);

		assertThat(priceWithDiscount, is(19.00));
	}
}
