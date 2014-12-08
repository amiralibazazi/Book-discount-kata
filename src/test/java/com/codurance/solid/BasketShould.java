package com.codurance.solid;

import com.codurance.builders.BasketBuilder;
import com.codurance.solid.discountCalculators.BookDiscountCalculator;
import org.junit.Test;

import static com.codurance.builders.BookBuilder.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BasketShould {
	
	@Test public void
	calculate_the_undiscounted_price_of_all_the_books_within_the_basket() {
		Basket basket = BasketBuilder.aBasket().with(
																				aCookingBook().costing(10.00).build(),
																				aCookingBook().costing(6.00).build(),
																				anITBook().costing(4.00).build(),
																				anITBook().costing(4.50).build(),
																				aFantasyBook().costing(3.50).build(),
																				aTravelBook().costing(3.50).build(),
																				aTravelBook().costing(8.50).build())
																		.buildWith(new BookDiscountCalculator());

		assertThat(basket.fullPrice(), is(40.00));
	} 
	
	@Test public void
	use_the_discount_calculator_when_to_calculate_the_discounted_price_of_books() {
		BookDiscountCalculator bookDiscountCalculator = mock(BookDiscountCalculator.class);
		Basket basket = new Basket(bookDiscountCalculator);
		basket.add(aTravelBook().build());

		basket.priceWithDiscount();

		verify(bookDiscountCalculator).calculate(basket.books());
	}
}
