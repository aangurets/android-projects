package by.aangurets.rssreader.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by aangurets on 06/12/2015.
 */

@Root(name = "rss", strict = false)
public class Rss {

    @Element(name = "channel")
    private Channel mChannel;

    public Rss() {
    }
}
