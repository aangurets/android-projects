package by.aangurets.rssreader.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by aangurets on 08/12/2015.
 */
@Root
public class ItemsList extends ArrayList<Item> {

    @Attribute(name = "version")
    private String mVersion;

    @Element(name = "channel")
    private Channel mChannel;

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
