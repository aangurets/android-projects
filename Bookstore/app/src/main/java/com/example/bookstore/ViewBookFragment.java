package com.example.bookstore;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewBookFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String mName = getArguments().getString(Constants.NAME);
        Log.d(Constants.LOG_TAG, "NAME!!!! = " + mName);
        return inflater.inflate(R.layout.fragment_view_book, container, false);
    }
}