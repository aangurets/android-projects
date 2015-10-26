package by.example.bookstore;

import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import by.example.bookstore.adapter.BookAdapter;
import by.example.bookstore.datahandling.DataParser;
import by.example.bookstore.loader.AbstractLoader;
import by.example.bookstore.model.Book;
import by.example.bookstore.model.BookStorage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BookstoreActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Book>> {

    private ListView mBookListView;

    @Nullable
    @Bind(R.id.book_view_code)
    TextView mCode;

    @Nullable
    @Bind(R.id.book_view_name)
    TextView mName;

    @Nullable
    @Bind(R.id.book_view_author)
    TextView mAuthor;

    @Nullable
    @Bind(R.id.book_view_language)
    TextView mLanguage;

    @Nullable
    @Bind(R.id.book_view_pages)
    TextView mPages;

    @Nullable
    @Bind(R.id.book_view_price)
    TextView mPrice;

    @Nullable
    @Bind(R.id.book_view_link)
    TextView mLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bookstore);

        ButterKnife.bind(this);

        BookstoreFragment mBookstoreFragment = (BookstoreFragment)
                getFragmentManager().findFragmentById(R.id.bookstore_fragment_id_in_activity);
        View mFragment = mBookstoreFragment.getView();

        mBookListView = (ListView) mFragment;
        try {
            mBookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String mString = BookstoreActivity.this.getString(R.string.screen_type);

                    goToViewBook(position, mString);
                }
            });
        } catch (NullPointerException e) {
            Log.d(Constants.LOG_TAG, "setOnItemClickListener.NullPointerException = " + e);
        }
        try {
            mBookListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    Book book = BookStorage.getInstance().getBook(position);
                    addOrDeleteFavoriteList(book);
                    return true;
                }
            });
        } catch (Exception e) {
            Log.d(Constants.LOG_TAG, "setOnItemLongClickListener.Exception = " + e);
        }
        getLoaderManager().initLoader(1, null, this);
    }

    private void goToViewBook(int position, String deviceType) {
        if (deviceType.equals("tablet")) {
            fillingFieldsInViewBookFragment(BookStorage.getInstance().getBook(position));
        } else if (deviceType.equals("phone")) {
            Intent intent = new Intent(BookstoreActivity.this, ViewBookActivity.class);
            intent.putExtra(Constants.SELECTED_BOOK, position);
            startActivity(intent);
        }
    }

    private void addOrDeleteFavoriteList(Book book) {
        if (book.isFavorite()) {
            Toast.makeText(BookstoreActivity.this, "Book \"" + book.getName()
                    + "\" remove from favorite", Toast.LENGTH_SHORT).show();
            BookStorage.getInstance().removeFavoriteBook(book);
        } else {
            Toast.makeText(BookstoreActivity.this, "Book \"" + book.getName()
                    + "\' added to favorite", Toast.LENGTH_SHORT).show();
            BookStorage.getInstance().addFavoriteBook(book);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bookstore_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.favorite_action:
                if (BookStorage.getInstance().getFavoritesBooks().isEmpty()) {
                    Toast.makeText(this, "No favorite books", Toast.LENGTH_SHORT).show();
                } else {
                    String mDeviceType = BookstoreActivity.this.getString(R.string.screen_type);

                    goToFavorite(mDeviceType);
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToFavorite(String deviceType) {
        if (deviceType.equals("tablet")) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            FavoriteBooksFragment mFavoriteBooksFragment = new FavoriteBooksFragment();
            ft.replace(R.id.bookstore_fragment_id_in_activity, mFavoriteBooksFragment);
            ft.commit();
        } else if (deviceType.equals("phone")) {
            Intent intent = new Intent(this, FavoriteBooksActivity.class);
            startActivity(intent);
        }
    }

    private void updateList() {
        ((BaseAdapter) mBookListView.getAdapter()).notifyDataSetChanged();
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

    public void fillingFieldsInViewBookFragment(Book book) {
        try {
            mCode.setText(book.getCode());
            mName.setText(book.getName());
            mAuthor.setText(book.getAuthor());
            mLanguage.setText(book.getLanguage());
            mPages.setText(book.getPages());
            mPrice.setText(book.getPrice());
            mLink.setText(book.getLink());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static class BookLoader extends AbstractLoader<List<Book>> {

        BookLoader(Context context) {
            super(context);
        }

        @Override
        public List<Book> loadInBackground() {
            DataParser mParser = new DataParser();
            URL mResource = null;
            try {
                mResource = new URL(Constants.URL);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return mParser.parseBookList(mResource);
        }

        @Override
        protected void freeResource(List<Book> data) {

        }

    }
}
