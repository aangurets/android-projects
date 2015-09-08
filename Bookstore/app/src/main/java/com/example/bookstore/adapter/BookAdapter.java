package com.example.bookstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bookstore.R;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookStorage;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    static final String CODE_CONST = "Code: ";
    static final String AUTH_CONST = "Author: ";
    static final String NAME_CONST = "Name: ";

    public BookAdapter(Context context, List<Book> books) {
        super(context, android.R.layout.simple_list_item_1, android.R.id.text1, books);
        LayoutInflater.from(context);
    }

    @Override
    public Book getItem(int position) {
        return BookStorage.getInstance().getBook(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mView = convertView;
        ViewHolder holder;
        if (mView == null) {
            mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book, parent, false);
            holder = new ViewHolder();
            holder.mCodeTextVew = (TextView) mView.findViewById(R.id.code_field);
            holder.mAuthorTextView = (TextView) mView.findViewById(R.id.author_field);
            holder.mNameTextVew = (TextView) mView.findViewById(R.id.name_field);
            mView.setTag(holder);
        } else {
            holder = (ViewHolder) mView.getTag();
        }
        holder.mCodeTextVew.setText(CODE_CONST + getItem(position).getCode());
        holder.mAuthorTextView.setText(AUTH_CONST + getItem(position).getAuthor());
        holder.mNameTextVew.setText(NAME_CONST + getItem(position).getName());
        return mView;

    }

    static class ViewHolder {
        public TextView mCodeTextVew;
        public TextView mAuthorTextView;
        public TextView mNameTextVew;
    }
}
