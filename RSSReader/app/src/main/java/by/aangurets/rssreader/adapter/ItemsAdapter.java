package by.aangurets.rssreader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import java.util.List;

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
        return super.getItemId(position);
    }
}
