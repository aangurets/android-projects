package by.aangurets.rssreader.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by aangurets on 06/12/2015.
 */
@Root(name = "image", strict = false)
public class Image {

    @Element(name = "title")
    private String mTitle;

    @Element(name = "link")
    private String mLink;

    @Element(name = "url")
    private String mUrl;

    public Image() {
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    @Override
    public String toString() {
        return "Image{" +
                "mTitle='" + mTitle + '\'' +
                ", mLink='" + mLink + '\'' +
                ", mUrl='" + mUrl + '\'' +
                '}';
    }
}
