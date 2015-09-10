package com.example.bookstore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookStorage;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewBookActivity extends AppCompatActivity {

    public static final String SELECTED_BOOK = "selected book position";

    private int mBookPosition;

    @Bind(R.id.book_view_code)
    TextView mCode;

    @Bind(R.id.book_view_name)
    TextView mName;

    @Bind(R.id.book_view_author)
    TextView mAuthor;

    @Bind(R.id.book_view_language)
    TextView mLanguage;

    @Bind(R.id.book_view_pages)
    TextView mPages;

    @Bind(R.id.book_view_price)
    TextView mPrice;

    @Bind(R.id.book_view_link)
    TextView mLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);

        ButterKnife.bind(this);
        setTitle(getString(R.string.view_book_activity_name));

        mBookPosition = getIntent().getIntExtra(SELECTED_BOOK, 0);
        Book mBook = BookStorage.getInstance().getBook(mBookPosition);
        fillingFields(mBook);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_action:
                return true;
            case R.id.switch_view_action:
                return true;
            case R.id.exit_action:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void fillingFields(Book book) {
        mCode.setText("Code: " + book.getCode());
        mName.setText("Name: " + book.getName());
        mAuthor.setText("Author: " + book.getAuthor());
        mLanguage.setText("Language: " + book.getLanguage());
        mPages.setText("Pages: " + book.getPages());
        mPrice.setText("Price: " + book.getPrice());
        mLink.setText("Link: " + book.getLink());
    }
}
