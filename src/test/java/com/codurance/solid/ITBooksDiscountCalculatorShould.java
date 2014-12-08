package com.codurance.solid;

import com.codurance.solid.discountCalculators.ITBooksDiscountCalculator;
import org.junit.Before;
import org.junit.Test;

import static com.codurance.builders.BookBuilder.*;
import static com.codurance.builders.BooksBuilder.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ITBooksDiscountCalculatorShould {

	private Books books;

	@Before
	public void initialise() {
	    books = new Books();
	}

	@Test public void
	apply_a_ten_percent_discount_for_up_to_two_books() {
		books = books().containing(
													anITBook().costing(6.00).build(),
													anITBook().costing(4.00).build())
											.build();

		double discount = new ITBooksDiscountCalculator().calculate(books);

		assertThat(discount, is(9.00));
	}

	@Test public void
	apply_a_thirty_percent_discount_if_there_are_more_than_2_books() {
		books = books().containing(
													anITBook().costing(6.00).build(),
													anITBook().costing(3.00).build(),
													anITBook().costing(1.00).build())
											.build();

		double discount = new ITBooksDiscountCalculator().calculate(books);

		assertThat(discount, is(7.00));
	}

}
