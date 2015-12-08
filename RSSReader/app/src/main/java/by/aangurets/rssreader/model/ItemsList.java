package by.aangurets.rssreader.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.ArrayList;

/**
 * Created by aangurets on 08/12/2015.
 */
public class ItemsList extends ArrayList<Item> {

    @Attribute(name = "version")
    private String mVersion;

    @Element(name = "channel")
    private Channel mChannel;
}
