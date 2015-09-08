package com.example.bookstore.model;

import java.util.ArrayList;
import java.util.List;

public class BookStorage {

    public static BookStorage sBookStorage;
    private List<Book> mBooks;

    public BookStorage() {
        mBooks = new ArrayList<>();
    }

    public static BookStorage getInstance() {
        if (sBookStorage == null) {
            sBookStorage = new BookStorage();
        }
        return sBookStorage;
    }

    public Book getBook(int position) {
        return mBooks.get(position);
    }

    public void addBook(Book book) {
        mBooks.add(book);
    }

    public List<Book> getBooks() {
        if (!mBooks.isEmpty()) {
            return mBooks;
        } else {
            throw new IllegalArgumentException("Book storage is empty!!");
        }
    }
}
