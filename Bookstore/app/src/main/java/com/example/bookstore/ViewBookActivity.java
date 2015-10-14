package com.example.bookstore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewBookActivity extends AppCompatActivity {

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

   //     fillingFields();

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

    public void fillingFields() {
        mCode.setText(getIntent().getStringExtra(Constants.CODE));
        mName.setText(getIntent().getStringExtra(Constants.NAME));
        mAuthor.setText(getIntent().getStringExtra(Constants.AUTHOR));
        mLanguage.setText(getIntent().getStringExtra(Constants.LANGUAGE));
        mPages.setText(getIntent().getStringExtra(Constants.PAGES));
        mPrice.setText(getIntent().getStringExtra(Constants.PRICE));
        mLink.setText(getIntent().getStringExtra(Constants.LINK));
    }
}
