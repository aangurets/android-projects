package by.aangurets.rssreader.storage;

import android.content.Context;
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
    private static List<Item> sItems;

    private DataBase mDataBase;

    public ItemsStorage(Context context) {
        mDataBase = new DataBase(context);
        sItems = new ArrayList<>();
    }

    public static ItemsStorage getInstance(Context context) {
        if (sItemsStorage == null) {
            sItemsStorage = new ItemsStorage(context);
        }
        return sItemsStorage;
    }

    public void addItem(Item item) {
        Log.d(Constants.LOG_TAG, "addItem " + item);
        mDataBase.addItem(item);
    }

    public Item getItem(int position) {
        Log.d(Constants.LOG_TAG, "getItem " + sItems.get(position));
        return sItems.get(position);
    }

    public List<Item> getItems() {
        Log.d(Constants.LOG_TAG, "getItems. Amount = " + sItems.size());
//        if (sItems.isEmpty()) {
        sItems = mDataBase.getAll();
//        }
        return sItems;
    }

    public void cleaningStorage() {
        Log.d(Constants.LOG_TAG, "cleaningStorage");
        sItems.clear();
    }
}
