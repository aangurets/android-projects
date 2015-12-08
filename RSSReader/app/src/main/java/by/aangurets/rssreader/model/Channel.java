package by.aangurets.rssreader.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by aangurets on 06/12/2015.
 */
@Root(name = "channel")
public class Channel {

    @Attribute(required = false)
    private String mAtomLink;

    @Element(name = "title")
    private String mTitle;

    @Element(name = "description")
    private String mDescription;

    @Element(name = "link")
    private String mLink;

    @Element(name = "image")
    private Image mImage;

    @Element(name = "language")
    private String mLanguage;

    @Element(name = "pubDate")
    private String mPubDate;

    @Element(name = "lastBuildDate")
    private String mLastBuildDate;

    @Element(name = "ttl")
    private int mTtl;

    @Element(name = "copyright")
    private String mCopyright;

    @ElementList(name = "item")
    List<Item> mItems;

    public Channel() {
    }

    public String getmAtomLink() {
        return mAtomLink;
    }

    public void setmAtomLink(String mAtomLink) {
        this.mAtomLink = mAtomLink;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }

    public Image getmImage() {
        return mImage;
    }

    public void setmImage(Image mImage) {
        this.mImage = mImage;
    }

    public String getmLanguage() {
        return mLanguage;
    }

    public void setmLanguage(String mLanguage) {
        this.mLanguage = mLanguage;
    }

    public String getmPubDate() {
        return mPubDate;
    }

    public void setmPubDate(String mPubDate) {
        this.mPubDate = mPubDate;
    }

    public String getmLastBuildDate() {
        return mLastBuildDate;
    }

    public void setmLastBuildDate(String mLastBuildDate) {
        this.mLastBuildDate = mLastBuildDate;
    }

    public int getmTtl() {
        return mTtl;
    }

    public void setmTtl(int mTtl) {
        this.mTtl = mTtl;
    }

    public String getmCopyright() {
        return mCopyright;
    }

    public void setmCopyright(String mCopyright) {
        this.mCopyright = mCopyright;
    }

    public List<Item> getmItems() {
        return mItems;
    }

    public void setmItems(List<Item> mItems) {
        this.mItems = mItems;
    }
}
