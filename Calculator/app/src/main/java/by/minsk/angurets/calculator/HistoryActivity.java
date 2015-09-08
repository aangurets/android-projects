package by.minsk.angurets.calculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HistoryActivity extends ActionBarActivity {

    private List<HistoryItem> historyItems = HistoryItemsStorage.getAll();
    @InjectView(R.id.listView)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_list);
        ButterKnife.inject(this);

        HistoryAdapter adapter = new HistoryAdapter(this, historyItems);

        mListView.setAdapter(adapter);
    }

}