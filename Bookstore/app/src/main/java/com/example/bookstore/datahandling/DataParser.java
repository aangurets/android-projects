package com.example.bookstore.datahandling;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookStorage;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.util.List;

/**
 * Created by aangurets on 22-Oct-15.
 */
public class DataParser {

    public List<Book> parseBookList(URL url) {
        try {
            ObjectMapper mapper =
                    new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,
                            false);
            Book[] books = mapper.readValue(url, Book[].class);
            for (Book book : books) {
                BookStorage.getInstance().addBook(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BookStorage.getInstance().getBooks();
    }
}
