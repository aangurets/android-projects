package by.aangurets.rssreader.model;

import java.util.Date;

/**
 * Created by andrei.angurets on 28/10/2015.
 */
public class Item {

    private String mTitle;
    private String mDescription;
    private String mLink;
    private String mGuid;
    private String mPubDate;
    private String mImageLink;
    private String mCategory;

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

    public String getmGuid() {
        return mGuid;
    }

    public void setmGuid(String mGuid) {
        this.mGuid = mGuid;
    }

    public String getmPubDate() {
        return mPubDate;
    }

    public void setmPubDate(String mPubDate) {
        this.mPubDate = mPubDate;
    }

    public String getmImageLink() {
        return mImageLink;
    }

    public void setmImageLink(String mImageLink) {
        this.mImageLink = mImageLink;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    @Override
    public String toString() {
        return "Item{" +
                "mTitle='" + mTitle + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mLink='" + mLink + '\'' +
                ", mGuid='" + mGuid + '\'' +
                ", mPubDate='" + mPubDate + '\'' +
                ", mImageLink='" + mImageLink + '\'' +
                ", mCategory='" + mCategory + '\'' +
                '}';
    }
}
