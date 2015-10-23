package by.example.bookstore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import by.example.bookstore.adapter.BookAdapter;
import by.example.bookstore.model.BookStorage;

/**
 * Created by andrei.angurets on 23/10/2015.
 */
public class FavoriteBooksActivity extends AppCompatActivity {

    private ListView mFavoriteBooksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_favorite_books);

        FavoriteBooksFragment mFavoriteBooksFragment = (FavoriteBooksFragment)
                getFragmentManager().findFragmentById(R.id.favorite_book_fragment_in_activity);

        View mFragment = mFavoriteBooksFragment.getView();

        mFavoriteBooksList = (ListView) mFragment;
        mFavoriteBooksList.setAdapter(new BookAdapter(this,
                BookStorage.getInstance().getFavoritesBooks()));
    }
}
