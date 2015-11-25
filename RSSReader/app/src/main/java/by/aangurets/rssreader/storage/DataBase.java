package by.aangurets.rssreader.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import by.aangurets.rssreader.model.Item;

public class DataBase {
    private static final String DATABASE_NAME = "news_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "news";
    private static final String ID = "_id";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String LINK = "link";
    private static final String GUID = "guid";
    private static final String PUB_DATE = "pub_date";
    private static final String IMAGE_LINK = "image_link";
    private static final String CATEGORY = "category";

    private SQLiteDatabase mDataBase;
    private SQLiteOpenHelper mDBHelper;

    public DataBase(Context context) {
        mDBHelper = new DBHelper(context);
        mDataBase = mDBHelper.getWritableDatabase();
    }

    public List<Item> getAll() {
        fillingDataBase();
        List<Item> mContacts = new ArrayList<>();
        Cursor cursor = mDataBase.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                int nameColumnIndex = cursor.getColumnIndex(TITLE);
                int surnameColumnIndex = cursor.getColumnIndex(DESCRIPTION);
                int phoneColumnIndex = cursor.getColumnIndex(LINK);
                int emailColumnIndex = cursor.getColumnIndex(GUID);
                int dateColumnIndex = cursor.getColumnIndex(PUB_DATE);
                int occupationColumnIndex = cursor.getColumnIndex(OCCUPATION);
                do {
                    I contact = new Contact();
                    contact.setName(cursor.getString(nameColumnIndex));
                    contact.setSurname(cursor.getString(surnameColumnIndex));
                    contact.setPhone(cursor.getString(phoneColumnIndex));
                    contact.setEmail(cursor.getString(emailColumnIndex));
                    contact.setDateOfBirdth(cursor.getString(dateColumnIndex));
                    contact.setOccupation(cursor.getString(occupationColumnIndex));
                    mContacts.add(contact);
                } while (cursor.moveToNext());
            }
        }
        return mContacts;
    }

    public void addItem(Item item) {
        mDataBase.insert(TABLE_NAME, null, getContentValuesFromContact(item));
    }

    public void dubbingItem(Item item) {
        mDataBase.update(TABLE_NAME, getContentValuesFromContact(item), ID + "=" +
                item.getId(), null);
    }

    public void deleteItem(Item item) {
        mDataBase.delete(TABLE_NAME, ID + "=" + item.getId(), null);
    }

    private ContentValues getContentValuesFromContact(Item item) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, item.getOccupation());
        contentValues.put(TITLE, item.getmTitle());
        contentValues.put(DESCRIPTION, item.getmDescription());
        contentValues.put(LINK, item.getmLink());
        contentValues.put(GUID, item.getmGuid());
        contentValues.put(PUB_DATE, item.getmPubDate());
        contentValues.put(IMAGE_LINK, item.getmImageLink());
        contentValues.put(CATEGORY, item.getmCategory());
        return contentValues;
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( " +
                    ID + " integer primary key autoincrement, " +
                    TITLE + " TEXT NOT NULL , " + DESCRIPTION + " TEXT NOT NULL , "
                    + LINK + " TEXT NOT NULL , " + GUID + " TEXT NOT NULL , "
                    + PUB_DATE + " TEXT NOT NULL , " + IMAGE_LINK + " TEXT NOT NULL"
                    + CATEGORY + " TEXT NOT NULL" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}
