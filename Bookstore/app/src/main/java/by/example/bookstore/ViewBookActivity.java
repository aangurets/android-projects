package by.example.bookstore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import by.example.bookstore.model.Book;
import by.example.bookstore.model.BookStorage;

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

        setTitle(getString(R.string.view_book_activity_name));

        ButterKnife.bind(this);

        int mPosition = getIntent().getIntExtra(Constants.SELECTED_BOOK, -1);
        if (mPosition != -1) {
            Book mBook = BookStorage.getInstance().getBook(mPosition);

            fillingFieldsInViewBookFragment(mBook);
        } else {
            Log.d(Constants.LOG_TAG, "Error. The position of the selected book is not received.");
        }
    }

    private void fillingFieldsInViewBookFragment(Book book) {
        mCode.setText(book.getCode());
        mName.setText(book.getName());
        mAuthor.setText(book.getAuthor());
        mLanguage.setText(book.getLanguage());
        mPages.setText(book.getPages());
        mPrice.setText(book.getPrice());
        mLink.setText(book.getLink());
    }
}
