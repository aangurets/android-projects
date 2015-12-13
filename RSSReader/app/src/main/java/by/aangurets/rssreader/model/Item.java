package by.aangurets.rssreader.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.text.ParseException;

/**
 * Created by andrei.angurets on 28/10/2015.
 */
@Root(name = "item", strict = false)
public class Item {

    private static int sCountId = 0;

    private int mId;

    @Element(name = "title")
    private String mTitle;

    @Element(name = "description")
    private String mDescription;

    @Element(name = "link")
    private String mLink;

    @Element(name = "guid")
    private String mGuid;

    @Element(name = "pubDate")
    private String mPubDate;

    @Element(name = "enclosure")
    private Enclosure mEnclosure;

    @Element(name = "category")
    private String mCategory;


    public Item() {
        this.mId = sCountId++;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String mLink) {
        this.mLink = mLink;
    }

    public String getGuid() {
        return mGuid;
    }

    public void setGuid(String mGuid) {
        this.mGuid = mGuid;
    }

    public String getPubDate() {

        return mPubDate;
    }

    public void setPubDate(String mPubDate) {
        try {
            this.mPubDate = DataFormatter.formattingDate(mPubDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getmEnclosure() {
        return mEnclosure.getmUrl();
    }

    public void setmEnclosure(String mEnclosure) {
        this.mEnclosure.setmUrl(mEnclosure);
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    @Override
    public String toString() {
        return "Item: " +
                " Title = " + mTitle +
                "; Description = " + mDescription +
                "; Link = " + mLink +
                "; Guid = " + mGuid +
                "; PubDate = " + mPubDate +
                "; Enclosure = " + mEnclosure +
                "; Category = " + mCategory +
                '}';
    }
}
