package by.aangurets.rssreader.datahandling;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import by.aangurets.rssreader.model.Item;

/**
 * Created by aangurets on 29-Oct-15.
 */
public class XMLRarsing {

    public static void parseXmlAndCreateNewItem(XmlPullParser xmlPullParser) {
        Item mItem = new Item();


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
