package com.codurance.solid;

import com.codurance.solid.discountCalculators.TravelBooksDiscountCalculator;
import org.junit.Test;

import static com.codurance.builders.BookBuilder.*;
import static com.codurance.builders.BooksBuilder.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TravelBookDiscountCalculatorShould {

	@Test public void
	apply_no_discount_for_up_to_3_books() {
		Books books = books().containing(
														aTravelBook().costing(7.00).build(),
														aTravelBook().costing(3.00).build())
												.build();

		double discount = new TravelBooksDiscountCalculator().calculate(books);

		assertThat(discount, is(10.00));
	}

	@Test public void
	apply_a_discount_for_when_there_are_more_than_3_books() {
		Books books = books().containing(
														aTravelBook().costing(3.00).build(),
														aTravelBook().costing(3.00).build(),
														aTravelBook().costing(3.00).build(),
														aTravelBook().costing(1.00).build())
												.build();

		double discount = new TravelBooksDiscountCalculator().calculate(books);

		assertThat(discount, is(6.00));
	}
}