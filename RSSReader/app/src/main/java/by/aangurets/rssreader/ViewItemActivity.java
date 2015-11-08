package by.aangurets.rssreader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by andrei.angurets on 07/11/2015.
 */
public class ViewItemActivity extends Activity {

    int mItemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        Intent mIntent = getIntent();
        mItemPosition = mIntent.getIntExtra(Constants.ITEM_POSITION, 0);
    }
}
