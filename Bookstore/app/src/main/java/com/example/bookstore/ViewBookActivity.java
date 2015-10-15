package com.example.bookstore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);

        setTitle(getString(R.string.view_book_activity_name));
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
}
