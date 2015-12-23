package by.aangurets.rssreader.model;

import org.simpleframework.xml.ElementList;

import java.util.ArrayList;

/**
 * Created by aangurets on 08/12/2015.
 */
public class ItemsList extends ArrayList<Item> {

    @ElementList(required = false)
    ArrayList<Item> items;

    public ItemsList() {
    }

    public ArrayList<Item> getmItems() {
        return items;
    }

    public void setmItems(ArrayList<Item> mItems) {
        this.items = mItems;
    }
}
