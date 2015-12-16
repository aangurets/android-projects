package by.aangurets.rssreader.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by aangurets on 09/12/2015.
 */
@Root(name = "enclosure")
public class Enclosure {

    @Attribute(name = "url")
    private String mUrl;

    @Attribute(name = "type")
    private String mType;

    @Attribute(name = "length")
    private int mLength;

    public Enclosure() {
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public int getmLength() {
        return mLength;
    }

    public void setmLength(int mLength) {
        this.mLength = mLength;
    }
}
