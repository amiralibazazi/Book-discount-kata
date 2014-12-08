package com.codurance.builders;

import com.codurance.solid.Book;
import com.codurance.solid.Books;

import static java.util.Arrays.asList;

public class BooksBuilder {
	private Book[] bookList = new Book[] {};

	public static BooksBuilder books() {
		return new BooksBuilder();
	}

	public BooksBuilder containing(Book... books) {
		this.bookList = books;
		return this;
	}

	public Books build() {
		Books books = new Books();
		books.addAll(asList(bookList));

		return books;
	}
}
