package com.example.jamieayer.project2;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


import Project2.Databases.DBRestaurantsAssetHelper;
import Project2.Databases.RestaurantsSQLiteOpenHelper;

/**
 * Created by JamieAyer on 3/21/16.
 */
public class RestaurantsListActivity extends AppCompatActivity {

    private CursorAdapter mCursorAdapter;
    private RestaurantsSQLiteOpenHelper mHelper;
    private ListView mRestaurantListView;
    private Cursor cursor;
    private TextView mTitle;
    private Typeface mFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_list);

        DBRestaurantsAssetHelper dbSetup = new DBRestaurantsAssetHelper(RestaurantsListActivity.this);
        dbSetup.getReadableDatabase();

        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        setTitle("Search for Restaurants");

        mTitle = (TextView)findViewById(R.id.restaurants);
        mFont = Typeface.createFromAsset(getAssets(), "fonts/AguafinaScript-Regular.ttf");
        mTitle.setTypeface(mFont);

        mRestaurantListView = (ListView)findViewById(R.id.restaurantsList);
        mHelper = new RestaurantsSQLiteOpenHelper(RestaurantsListActivity.this);

        cursor = mHelper.getRestaurantList();

        mCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,new String[]{RestaurantsSQLiteOpenHelper.COL_NAME},new int[]{android.R.id.text1},0);
        mRestaurantListView.setAdapter(mCursorAdapter);

        handleIntent(getIntent());

        mRestaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RestaurantsListActivity.this, DetailActivity.class);
                cursor.moveToPosition(position);
                intent.putExtra("id", cursor.getInt(cursor.getColumnIndex("_id")));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.restaurant_list_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView)menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewDetachedFromWindow(View v) {
                searchView.clearFocus();
                cursor = mHelper.getRestaurantList();
                mCursorAdapter.swapCursor(cursor);
            }

            @Override
            public void onViewAttachedToWindow(View v) {

            }
        });

        return true;
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {

            String query = intent.getStringExtra(SearchManager.QUERY);
            cursor = RestaurantsSQLiteOpenHelper.getInstance(RestaurantsListActivity.this).searchList(query);

            mCursorAdapter.swapCursor(cursor);
        }
    }
}
