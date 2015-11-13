package by.aangurets.rssreader.datahandling;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by aangurets on 13-Nov-15.
 */
public class ReceiverImage {

    public static Bitmap getBitmapFromUrl(String url) {
        try {
            URL mUrl = new URL(url);
            HttpURLConnection mConnection = (HttpURLConnection) mUrl.openConnection();
            mConnection.setDoInput(true);
            mConnection.connect();
            InputStream mInputStream = mConnection.getInputStream();
            Bitmap mBitmap = BitmapFactory.decodeStream(mInputStream);
            mInputStream.close();
            return mBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
