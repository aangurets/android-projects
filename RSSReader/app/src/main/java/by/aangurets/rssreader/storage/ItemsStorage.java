package by.aangurets.rssreader.storage;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import by.aangurets.rssreader.Constants;
import by.aangurets.rssreader.ReaderActivity;
import by.aangurets.rssreader.model.Item;

/**
 * Created by aangurets on 29-Oct-15.
 */
public class ItemsStorage {

    public static ItemsStorage sItemsStorage;
    private static List<Item> sItems;

    public ItemsStorage() {
        sItems = new ArrayList<>();
    }

    public static ItemsStorage getInstance() {
        if (sItemsStorage == null) {
            sItemsStorage = new ItemsStorage();
        }
        return sItemsStorage;
    }

    public void addItem(Item item) {
        sItems.add(item);
        Log.d(Constants.LOG_TAG, "addItem " + item + ", Items.size = " + sItems.size());
        new ReaderActivity().updateList();
//        new ReaderActivity().mAdapter.notifyDataSetChanged();
    }

    public Item getItem(int position) {
//        Log.d(Constants.LOG_TAG, "getItem " + sItems.get(position));
        return sItems.get(position);
    }

    public List<Item> getItems() {
        Log.d(Constants.LOG_TAG, "getItems. Amount = " + sItems.size());
        return sItems;
    }

    public void cleaningStorage() {
        Log.d(Constants.LOG_TAG, "cleaningStorage");
        sItems.clear();
    }
}
