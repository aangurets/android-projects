package by.example.bookstore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by andrei.angurets on 23/10/2015.
 */
public class FavoriteBooksActivity extends AppCompatActivity {

    private ListView mFavoriteBooksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_favorite_books);
    }
}
