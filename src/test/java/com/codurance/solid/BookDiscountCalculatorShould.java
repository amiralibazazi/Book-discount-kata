package com.codurance.solid;

import com.codurance.solid.discountCalculators.BookDiscountCalculator;
import org.junit.Test;

import static com.codurance.builders.BookBuilder.*;
import static com.codurance.builders.BooksBuilder.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookDiscountCalculatorShould {

	@Test
	public void
	calculate_a_total_price_of_zero_with_no_books() {
		BookDiscountCalculator bookDiscountCalculator = new BookDiscountCalculator();
		Books books = new Books();

		assertThat(bookDiscountCalculator.calculate(books), is(0.0));
	}

	@Test public void
	calculate_discounted_prices_of_each_type_of_book() {
		BookDiscountCalculator bookDiscountCalculator = new BookDiscountCalculator();
		Books books = books().containing(
																aCookingBook().costing(10.00).build(),
																aFantasyBook().costing(10.00).build(),
																aFantasyBook().costing(10.00).build(),
																anITBook().costing(10.00).build(),
																anITBook().costing(10.00).build(),
																aTravelBook().costing(10.00).build(),
																aTravelBook().costing(10.00).build(),
																aTravelBook().costing(10.00).build(),
																aTravelBook().costing(10.00).build())
														.build();

		assertThat(bookDiscountCalculator.calculate(books), is(68.00));
	}

}
