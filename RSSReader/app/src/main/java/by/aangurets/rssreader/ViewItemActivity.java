package by.aangurets.rssreader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.androidquery.AQuery;

import butterknife.Bind;
import butterknife.ButterKnife;
import by.aangurets.rssreader.model.Item;
import by.aangurets.rssreader.storage.ItemsStorage;

/**
 * Created by andrei.angurets on 07/11/2015.
 */
public class ViewItemActivity extends Activity {

    @Bind(R.id.titleInViewItem)
    TextView mTitle;

    @Bind(R.id.dateInViewItem)
    TextView mDate;

    @Bind(R.id.descriptionInViewItem)
    TextView mDescription;

    AQuery mAquery = new AQuery(this);
    int mItemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        ButterKnife.bind(this);

        Intent mIntent = getIntent();
        mItemPosition = mIntent.getIntExtra(Constants.ITEM_POSITION, 0);

        Item mSelectedItem = ItemsStorage.getInstance().getItem(mItemPosition);

        completeData(mSelectedItem);
    }

    private void completeData(Item item) {
        mAquery.id(R.id.imageInViewItem).image(item.getmImageLink());
        mTitle.setText(item.getmTitle());
        mDate.setText(item.getmPubDate());

        // TODO: ImageGetter (getting image from HTML text)
        mDescription.setText(Html.fromHtml(item.getmDescription()));
    }
}
