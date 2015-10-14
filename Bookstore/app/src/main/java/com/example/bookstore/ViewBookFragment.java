package com.example.bookstore;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

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
        Context mContext;

        TextView mCode = (TextView) getActivity().findViewById(R.id.book_view_code);

        TextView mName = (TextView)getActivity().findViewById(R.id.book_view_name);

        mCode.setText(Integer.toString(99999999));
        mName.setText("Yaaaahhhhooooooooo");

        mBundle = this.getArguments();
        if (mBundle != null) {
            mPosition = mBundle.getInt(Constants.SELECTED_BOOK);
        }

        Log.d(Constants.LOG_TAG, "mPosition = " + mPosition);
    }
}