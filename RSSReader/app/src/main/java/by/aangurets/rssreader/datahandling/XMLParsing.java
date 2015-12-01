package by.aangurets.rssreader.datahandling;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import by.aangurets.rssreader.Constants;
import by.aangurets.rssreader.ReaderActivity;
import by.aangurets.rssreader.model.Item;
import by.aangurets.rssreader.storage.ItemsStorage;

/**
 * Created by aangurets on 29-Oct-15.
 */
public class XMLParsing {

    public static void parseXmlAndCreateNewItem(XmlPullParser xmlPullParser) {
        Log.d(Constants.LOG_TAG, "'parseXmlAndCreateNewItem");
        Context mContext = new ReaderActivity();
        Item mItem = new Item();
        String mText = null;
        int mEvent;

        try {
            mEvent = xmlPullParser.getEventType();

            while (mEvent != XmlPullParser.END_DOCUMENT) {
                String mName = xmlPullParser.getName();

                switch (mEvent) {
                    case XmlPullParser.START_DOCUMENT:
                        break;

                    case XmlPullParser.START_TAG:
                        break;

                    case XmlPullParser.TEXT:
                        mText = xmlPullParser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (mName.equals("item")) {
                            mItem = new Item();
                        } else if (mName.equals("title")) {
                            mItem.setTitle(mText);
                        } else if (mName.equals("description")) {
                            mItem.setDescription(mText);
                        } else if (mName.equals("link")) {
                            mItem.setLink(mText);
                        } else if (mName.equals("guid")) {
                            mItem.setGuid(mText);
                        } else if (mName.equals("pubDate")) {
                            mItem.setPubDate(mText);
                        } else if (mName.equals("enclosure")) {
                            String mImageUrl = xmlPullParser.getAttributeValue(null, "url");
                            mItem.setImageLink(mImageUrl);
                            mItem.setImage(ReceiverImage.getBitmapFromUrl(mImageUrl));
                        } else if (mName.equals("category")) {
                            mItem.setCategory(mText);
                            ItemsStorage.getInstance(mContext).addItem(mItem);
                        }
                        break;
                }
                mEvent = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getXML(final String url) {
        Log.d(Constants.LOG_TAG, "getXML");

        Thread mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL mUrl = new URL(url);
                    HttpURLConnection mConnection = (HttpURLConnection) mUrl.openConnection();

                    mConnection.setReadTimeout(10000);
                    mConnection.setConnectTimeout(15000);
                    mConnection.setRequestMethod("GET");
                    mConnection.setDoInput(true);

                    mConnection.connect();
                    InputStream mStream = mConnection.getInputStream();

                    XmlPullParserFactory mXmlFactoryObject = XmlPullParserFactory.newInstance();
                    XmlPullParser mParser = mXmlFactoryObject.newPullParser();

                    mParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    mParser.setInput(mStream, null);

                    parseXmlAndCreateNewItem(mParser);
                    mStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mThread.start();
    }
}
