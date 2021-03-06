package by.example.bookstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import by.example.bookstore.Constants;
import by.example.bookstore.R;
import by.example.bookstore.model.Book;
import by.example.bookstore.model.BookStorage;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

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
            holder.mAuthorTextView = (TextView) mView.findViewById(R.id.author_field);
            holder.mNameTextVew = (TextView) mView.findViewById(R.id.name_field);
            mView.setTag(holder);
        } else {
            holder = (ViewHolder) mView.getTag();
        }
        String mAuthor = Constants.AUTHOR + getItem(position).getAuthor();
        String mName = Constants.NAME + getItem(position).getName();

        holder.mAuthorTextView.setText(mAuthor);
        holder.mNameTextVew.setText(mName);

        return mView;
    }

    static class ViewHolder {
        public TextView mAuthorTextView;
        public TextView mNameTextVew;
    }
}
