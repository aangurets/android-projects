package by.aangurets.rssreader.model;

import android.graphics.Bitmap;

import java.text.ParseException;

/**
 * Created by andrei.angurets on 28/10/2015.
 */
public class Item {

    private int mId;
    private String mTitle;
    private String mDescription;
    private String mLink;
    private String mGuid;
    private String mPubDate;
    private String mImageLink;
    private Bitmap mImage;
    private String mCategory;

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

    public String getImageLink() {
        return mImageLink;
    }

    public void setImageLink(String mImageLink) {
        this.mImageLink = mImageLink;
    }

    public Bitmap getImage() {
        return mImage;
    }

    public void setImage(Bitmap mImage) {
        this.mImage = mImage;
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
                "; ImageLink = " + mImageLink +
                "; Category = " + mCategory +
                '}';
    }
}
