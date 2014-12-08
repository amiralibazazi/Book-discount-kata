package com.codurance.solid;

import java.util.*;

import static java.util.Arrays.*;

public class Books {

	private List<Book> bookList;

	public Books() {
		bookList = new ArrayList<>();
	}

	public void add(Book item) {
		bookList.add(item);
	}

	public List<Book> all() {
		return Collections.unmodifiableList(bookList);
	}

	public int numberOf(BookType bookType) {
		return (int) bookList.stream()
													.filter(book -> bookType.equals(book.type())).count();
	}

	public double priceOfAll(BookType... types) {
		List<BookType> typeList = asList(types);
		return bookList.stream()
											.filter(book -> typeList.contains(book.type()))
											.map(book -> book.price())
											.reduce(0.0, (p1, p2) -> p1 + p2);
	}

	public void addAll(List<Book> books) {
		bookList.addAll(books);
	}
}
