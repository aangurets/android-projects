package by.aangurets.rssreader;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import by.aangurets.rssreader.adapter.ItemsAdapter;
import by.aangurets.rssreader.datahandling.XMLParsing;
import by.aangurets.rssreader.loader.AbstractLoader;
import by.aangurets.rssreader.model.Item;
import by.aangurets.rssreader.storage.ItemsStorage;

public class ReaderActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        LoaderManager.LoaderCallbacks<List<Item>> {

    public static final int LOADER_ID = 1;

    private ListView mItemsListView;
    private Activity mActivity = new Activity();
    public ItemsAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(Constants.LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        ItemsStorage.getInstance().cleaningStorage();

        mAdapter = new ItemsAdapter(this, new ArrayList<Item>());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ItemsListFragment mItemsListFragment = (ItemsListFragment)
                getFragmentManager().findFragmentById(R.id.news_list_fragment_in_activity);
        View mFragment = mItemsListFragment.getView();

        mItemsListView = (ListView) mFragment;

        getLoaderManager().initLoader(LOADER_ID, null, this);

        mItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                updateList();
                Intent mIntent = new Intent(ReaderActivity.this, ViewItemActivity.class);
                mIntent.putExtra(Constants.ITEM_POSITION, position);
                startActivity(mIntent);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mItemsListView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        Log.d(Constants.LOG_TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        Log.d(Constants.LOG_TAG, "onBackPressed");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.reader, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent mActivity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStop() {
        Log.d(Constants.LOG_TAG, "onStop");
        super.onStop();
    }

    private Handler mHandler = new Handler();

    public void updateList() {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(Constants.LOG_TAG, "updateList");
//                        ((ItemsAdapter) mItemsListView.getAdapter()).notifyDataSetChanged();
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    @Override
    public Loader<List<Item>> onCreateLoader(int id, Bundle args) {
        Log.d(Constants.LOG_TAG, "onCreateLoader");
        return new ItemsLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Item>> loader, List<Item> data) {
        Log.d(Constants.LOG_TAG, "onLoadFinished");
        mAdapter = new ItemsAdapter(this, data);
        mItemsListView.setAdapter(mAdapter);
    }

    @Override
    public void onLoaderReset(Loader<List<Item>> loader) {
//        Log.d(Constants.LOG_TAG, "onLoaderReset");
//        ItemsStorage.getInstance().cleaningStorage();
    }

    private static class ItemsLoader extends AbstractLoader<List<Item>> {

        public ItemsLoader(Context context) {
            super(context);
        }

        @Override
        public List<Item> loadInBackground() {
            Log.d(Constants.LOG_TAG, "loadInBackground");
            return new XMLParsing().getXML(Constants.FAKTY_URL);
        }

        @Override
        protected void onStartLoading() {
            super.onStartLoading();
        }


        @Override
        protected void freeResource(List<Item> data) {

        }
    }
}
