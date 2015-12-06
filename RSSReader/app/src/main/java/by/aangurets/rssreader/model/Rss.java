package by.aangurets.rssreader.model;

import org.simpleframework.xml.Root;

/**
 * Created by aangurets on 06/12/2015.
 */

@Root(name = "rss", strict = false)
public class Rss {

    private Channel mChannel;

    public Rss() {
    }

    public Rss(Channel mChannel) {
        this.mChannel = mChannel;
    }
}
