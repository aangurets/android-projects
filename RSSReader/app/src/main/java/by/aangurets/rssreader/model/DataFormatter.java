package by.aangurets.rssreader.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by andrei.angurets on 03/11/2015.
 */
public class DataFormatter {

    public static String formattingDate(String date) throws ParseException {
        SimpleDateFormat mFormat = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss Z");
        Date mNewDate = mFormat.parse(date);

        mFormat = new SimpleDateFormat("hh:mm, MMM dd, yyyy", new Locale("pl", "PL"));
        return mFormat.format(mNewDate);
    }
}
