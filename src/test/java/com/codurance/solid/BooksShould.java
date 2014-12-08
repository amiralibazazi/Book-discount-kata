package com.codurance.solid;

import org.junit.Before;
import org.junit.Test;

import static com.codurance.builders.BookBuilder.*;
import static com.codurance.builders.BooksBuilder.books;
import static com.codurance.solid.BookType.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BooksShould {

	private Books books;

	@Before
	public void initialise() {
		books = new Books();
	}

	@Test public void
	inform_the_number_of_different_types_of_books() {
		books = books().containing(
													aCookingBook().build(),
													aTravelBook().build(),
													aTravelBook().build(),
													aTravelBook().build(),
													anITBook().build(),
													anITBook().build())
											.build();

		assertThat(books.numberOf(IT), is(2));
		assertThat(books.numberOf(TRAVEL), is(3));
	}

	@Test public void
	inform_the_price_of_different_types_of_books() {
		books = books().containing(
													aCookingBook().costing(1.20).build(),
													aTravelBook().costing(1.40).build(),
													aTravelBook().costing(1.40).build(),
													aTravelBook().costing(2.70).build(),
													anITBook().costing(0.30).build())
											.build();

	    assertThat(books.priceOfAll(IT), is(0.30));
	    assertThat(books.priceOfAll(COOKING), is(1.20));
	    assertThat(books.priceOfAll(TRAVEL), is(5.50));
	}
}
