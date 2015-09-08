package com.example.bookstore;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.bookstore.adapter.BookAdapter;
import com.example.bookstore.loader.AbstractLoader;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookStorage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.util.List;

public class BookstoreActivity extends ActionBarActivity
        implements LoaderManager.LoaderCallbacks<List<Book>> {

    public static final String SELECTED_BOOK = "selected book position";

    private ListView mBookListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

 //       setContentView(R.layout.fragment_bookstore);

        mBookListView = (ListView) findViewById(android.R.id.list);
        mBookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BookstoreActivity.this, ViewBookActivity.class);
                intent.putExtra(SELECTED_BOOK, position);
                startActivity(intent);
            }
        });

        getLoaderManager().initLoader(1, null, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bookstore_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public Loader<List<Book>> onCreateLoader(int id, Bundle args) {
        return new BookLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> data) {
        mBookListView.setAdapter(new BookAdapter(this, data));
    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
    }

    private static class BookLoader extends AbstractLoader<List<Book>> {

        BookLoader(Context context) {
            super(context);
        }

        @Override
        public List<Book> loadInBackground() {
            ObjectMapper mapper = new ObjectMapper();
            try {
                java.net.URL mResource =
                        new URL("http://bride.by/books.json");
                Book[] books = mapper.readValue(mResource, Book[].class);
                for (Book book : books) {
                    BookStorage.getInstance().addBook(book);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return BookStorage.getInstance().getBooks();
        }

        @Override
        protected void freeResource(List<Book> data) {

        }

    }
}
