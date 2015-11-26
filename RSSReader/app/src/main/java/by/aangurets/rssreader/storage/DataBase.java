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
        List<Item> mItems = new ArrayList<>();
        Cursor cursor = mDataBase.query(TABLE_NAME, null, null, null, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                int titleColumnIndex = cursor.getColumnIndex(TITLE);
                int descriptionColumnIndex = cursor.getColumnIndex(DESCRIPTION);
                int linkColumnIndex = cursor.getColumnIndex(LINK);
                int guidColumnIndex = cursor.getColumnIndex(GUID);
                int pubDateColumnIndex = cursor.getColumnIndex(PUB_DATE);
                int imageLinkColumnIndex = cursor.getColumnIndex(IMAGE_LINK);
                int categoryColumnIndex = cursor.getColumnIndex(CATEGORY);
                do {
                    Item item = new Item();
                    item.setTitle(cursor.getString(titleColumnIndex));
                    item.setDescription(cursor.getString(descriptionColumnIndex));
                    item.setLink(cursor.getString(linkColumnIndex));
                    item.setGuid(cursor.getString(guidColumnIndex));
                    item.setPubDate(cursor.getString(pubDateColumnIndex));
                    item.setImageLink(cursor.getString(imageLinkColumnIndex));
                    item.setCategory(cursor.getString(categoryColumnIndex));
                    mItems.add(item);
                } while (cursor.moveToNext());
            }
        }
        return mItems;
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
        contentValues.put(ID, item.getId());
        contentValues.put(TITLE, item.getTitle());
        contentValues.put(DESCRIPTION, item.getDescription());
        contentValues.put(LINK, item.getLink());
        contentValues.put(GUID, item.getGuid());
        contentValues.put(PUB_DATE, item.getPubDate());
        contentValues.put(IMAGE_LINK, item.getImageLink());
        contentValues.put(CATEGORY, item.getCategory());
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
