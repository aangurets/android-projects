package by.aangurets.rssreader.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by aangurets on 06/12/2015.
 */

@Root(name = "rss", strict = false)
public class Rss {

    @Attribute(name = "atom", required = false)
    private String atom;

    @Attribute(name = "version", required = false)
    private String version;

    @Element(name = "channel")
    private Channel mChannel;

    public Rss() {
    }

    public String getAtom() {
        return atom;
    }

    public void setAtom(String atom) {
        this.atom = atom;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Channel getmChannel() {
        return mChannel;
    }

    public void setmChannel(Channel mChannel) {
        this.mChannel = mChannel;
    }
}
