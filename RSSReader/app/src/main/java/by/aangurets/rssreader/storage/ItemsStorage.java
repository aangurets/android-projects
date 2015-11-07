package by.aangurets.rssreader.storage;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import by.aangurets.rssreader.Constants;
import by.aangurets.rssreader.model.Item;

/**
 * Created by aangurets on 29-Oct-15.
 */
public class ItemsStorage {

    public static ItemsStorage sItemsStorage;
    private List<Item> mItems;

    public ItemsStorage() {
        mItems = new ArrayList<>();
    }

    public static ItemsStorage getInstance() {
        if (sItemsStorage == null) {
            sItemsStorage = new ItemsStorage();
        }
        return sItemsStorage;
    }

    public void addItem(Item item) {
        mItems.add(item);
//        Log.d(Constants.LOG_TAG, "addItem " + item + ", Items.size = " + mItems.size());
    }

    public Item getItem(int position) {
//        Log.d(Constants.LOG_TAG, "getItem " + mItems.get(position));
        return mItems.get(position);
    }

    public List<Item> getItems() {
//        Log.d(Constants.LOG_TAG, "getItems");
        return mItems;
    }
}
