package by.aangurets.rssreader.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.ArrayList;

/**
 * Created by aangurets on 08/12/2015.
 */
public class ItemsList extends ArrayList<Item> {

    @Attribute(name = "version")
    private String mVersion;

    @Element(name = "channel")
    private Channel mChannel;

    @ElementList(entry = "item", inline = false, empty = true, data = false, required = true)
    ArrayList<Item> mItems;

    public ItemsList() {
    }

    public ArrayList<Item> getmItems() {
        return mItems;
    }

    public void setmItems(ArrayList<Item> mItems) {
        this.mItems = mItems;
    }
}
