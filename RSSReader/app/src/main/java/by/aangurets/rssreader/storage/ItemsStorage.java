package by.aangurets.rssreader.storage;

import java.util.ArrayList;
import java.util.List;

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
    }

    public Item getItem(int position) {
        return mItems.get(position);
    }

    public List<Item> getItems() {
        if (!mItems.isEmpty()) {
            return mItems;
        } else {
            throw new IllegalArgumentException("Items list empty");
        }
    }
}
