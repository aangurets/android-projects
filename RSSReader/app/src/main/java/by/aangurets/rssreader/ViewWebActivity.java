package by.aangurets.rssreader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by andrei.angurets on 22/11/2015.
 */
public class ViewWebActivity extends Activity {

    @Bind(R.id.webView)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_web);

        ButterKnife.bind(this);

        Intent mIntent = getIntent();
        String mUrl = mIntent.getStringExtra(Constants.URL);

        mWebView.loadUrl(mUrl);
    }
}
