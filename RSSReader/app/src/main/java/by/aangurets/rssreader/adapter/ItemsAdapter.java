package by.aangurets.rssreader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import android.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import by.aangurets.rssreader.R;
import by.aangurets.rssreader.model.Item;
import by.aangurets.rssreader.storage.ItemsStorage;

/**
 * Created by andrei.angurets on 02/11/2015.
 */
public class ItemsAdapter extends ArrayAdapter<Item> {

    public ItemsAdapter(Context context, List<Item> items) {
        super(context, android.R.layout.simple_list_item_1, android.R.id.text1, items);
        LayoutInflater.from(context);
    }

    @Override
    public Item getItem(int position) {
        return ItemsStorage.getInstance().getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mView = convertView;
        ViewHolder mHolder;
        URI mUri = null;

        if (mView == null) {
            mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            mHolder = new ViewHolder();
            mHolder.mTitle = (TextView) mView.findViewById(R.id.itemTitle);
            mHolder.mDate = (TextView) mView.findViewById(R.id.itemTitle);
            mHolder.mImage = (ImageView) mView.findViewById(R.id.itemImage);
            mView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) mView.getTag();
        }

        try {
           mUri  = new URI(getItem(position).getmImageLink());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        mHolder.mTitle.setText(getItem(position).getmTitle());
        mHolder.mDate.setText(getItem(position).getmPubDate());
        mHolder.mImage.setImageURI(mUri);

        return super.getView(position, convertView, parent);
    }

    static class ViewHolder {
        public TextView mTitle;
        public TextView mDate;
        public ImageView mImage;
    }
}
