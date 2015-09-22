package com.example.bookstore;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bookstore.adapter.BookAdapter;
import com.example.bookstore.loader.AbstractLoader;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookStorage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.util.List;

public class BookstoreActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Book>> {

    private ListView mBookListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bookstore);

        BookstoreFragment mBookstoreFragment = (BookstoreFragment)
                getFragmentManager().findFragmentById(R.id.bookstore_fragment_id_in_activity);
        View mFragment = mBookstoreFragment.getView();

        try {
            mBookListView = (ListView) mFragment;
            mBookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String mString = BookstoreActivity.this.getString(R.string.screen_type);
                    Book mBook = BookStorage.getInstance().getBook(position);

                    if (mString.equals("tablet")) {

                    } else if (mString.equals("phone")) {
                        Intent intent = new Intent(BookstoreActivity.this, ViewBookActivity.class);
                        intent.putExtra(Constants.CODE, mBook.getCode());
                        intent.putExtra(Constants.NAME, mBook.getName());
                        intent.putExtra(Constants.AUTHOR, mBook.getAuthor());
                        intent.putExtra(Constants.LANGUAGE, mBook.getLanguage());
                        intent.putExtra(Constants.PAGES, mBook.getPages());
                        intent.putExtra(Constants.PRICE, mBook.getPrice());
                        intent.putExtra(Constants.LINK, mBook.getLink());
                        startActivity(intent);
                    }
                }
            });
        } catch (NullPointerException e) {
            Log.d(Constants.LOG_TAG, "Error = " + e);
        }
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
                        new URL(Constants.URL);
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
