package com.example.bookstore;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewBookFragment extends Fragment {

    Bundle mBundle;
    int mPosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_book, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBundle = this.getArguments();
        if (mBundle != null) {
            mPosition = mBundle.getInt(Constants.SELECTED_BOOK);
        }

        Log.d(Constants.LOG_TAG, "mPosition = " + mPosition);
    }
}