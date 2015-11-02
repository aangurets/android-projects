package by.aangurets.rssreader.datahandling;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import by.aangurets.rssreader.Constants;
import by.aangurets.rssreader.model.Item;
import by.aangurets.rssreader.storage.ItemsStorage;

/**
 * Created by aangurets on 29-Oct-15.
 */
public class XMLParsing {

    public static void parseXmlAndCreateNewItem(XmlPullParser xmlPullParser) {
        Log.d(Constants.LOG_TAG, "parseXmlAndCreateNewItem");
        Item mItem = new Item();
        String mText = null;
        int mEvent;

        try {
            mEvent = xmlPullParser.getEventType();

            while (mEvent != XmlPullParser.END_DOCUMENT) {
                String mName = xmlPullParser.getName();
                Log.d(Constants.LOG_TAG, "mName = " + mName);

                switch (mEvent) {
                    case XmlPullParser.START_TAG:
                        break;

                    case XmlPullParser.TEXT:
                        mText = xmlPullParser.getText();
                        break;

                    case XmlPullParser.END_TAG:

                        if (mName != null) {
                            if (mName.equals("title")) {
                                mItem.setmTitle(mText);
                            } else if (mName.equals("description")) {
                                mItem.setmDescription(mText);
                            } else if (mName.equals("link")) {
                                mItem.setmLink(mText);
                            } else if (mName.equals("guid")) {
                                mItem.setmGuid(mText);
                            } else if (mName.equals("pubDate")) {
                                mItem.setmPubDate(mText);
                            } else if (mName.equals("enclosure")) {
                                mItem.setmImageLink(mText);
                            } else if (mName.equals("category")) {
                                mItem.setmCategory(mText);
                            }
                        }
                        ItemsStorage.getInstance().addItem(mItem);
                        break;
                }
                mEvent = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getXML(final String url) {
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
