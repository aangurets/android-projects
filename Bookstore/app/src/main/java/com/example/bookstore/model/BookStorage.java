package com.example.bookstore.model;

import android.util.Log;

import com.example.bookstore.Constants;

import java.util.ArrayList;
import java.util.List;

public class BookStorage {

    public static BookStorage sBookStorage;
    private List<Book> mBooks;
    private List<Book> mFavoriteBooks;

    public BookStorage() {
        mBooks = new ArrayList<>();
        mFavoriteBooks = new ArrayList<>();
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

    public void addFavoriteBook(Book book) {
        mFavoriteBooks.add(book);
        book.setIsFavorite(true);
        Log.d(Constants.LOG_TAG, "Is favorite book \""
                + book.getName() + "\" flag = " + book.isFavorite());
    }

    public List<Book> getBooks() {
        if (!mBooks.isEmpty()) {
            return mBooks;
        } else {
            throw new IllegalArgumentException("Book storage is empty!!");
        }
    }

    public List<Book> getFavoritesBooks() {
        if (!mFavoriteBooks.isEmpty()) {
            return mFavoriteBooks;
        } else {
            throw new IllegalArgumentException("Favorite books list is empty");
        }
    }
}
