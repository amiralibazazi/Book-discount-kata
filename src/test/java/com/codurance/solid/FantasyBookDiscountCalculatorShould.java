package com.codurance.solid;

import com.codurance.solid.discountCalculators.FantasyBookDiscountCalculator;
import org.junit.Test;

import static com.codurance.builders.BookBuilder.*;
import static com.codurance.builders.BooksBuilder.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FantasyBookDiscountCalculatorShould {

	@Test public void
	apply_no_discount_for_up_to_one_fantasy_book() {
		Books books = books().containing(
															aFantasyBook().costing(20.00).build())
														.build();

		double priceWithDiscount = new FantasyBookDiscountCalculator().calculate(books);

		assertThat(priceWithDiscount, is(20.00));
	}
	
	@Test public void
	apply_a_discount_of_20_percent_for_two_or_more_books() {
		Books books = books().containing(
				aFantasyBook().costing(10.00).build(),
				aFantasyBook().costing(8.00).build(),
				aFantasyBook().costing(2.00).build())
				.build();

		double priceWithDiscount = new FantasyBookDiscountCalculator().calculate(books);

	    assertThat(priceWithDiscount, is(16.00));
	} 
}
