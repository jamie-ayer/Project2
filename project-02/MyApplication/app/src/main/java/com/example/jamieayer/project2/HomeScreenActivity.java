package com.example.jamieayer.project2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
<<<<<<< HEAD
import android.content.SharedPreferences;
=======
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
import com.google.gson.Gson;

=======
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
import java.util.ArrayList;
import java.util.LinkedHashSet;

import Project2.Adapters.CustomAdapterFavorites;
import Project2.Databases.RestaurantsSQLiteOpenHelper;
import Project2.Objects.Restaurant;
import Project2.Objects.User;

/**
 * Created by JamieAyer on 3/21/16.
 */
public class HomeScreenActivity extends AppCompatActivity {

    private Button mLogOut;
    private Button mMoreRestaurants;

    private Typeface mFont;
    private TextView mTitle;
    private TextView mGreeting;

    private ListView homeScreenListView;
    private CustomAdapterFavorites myAdapter;
    private ArrayList<Restaurant> myArrayList;
    private RestaurantsSQLiteOpenHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

<<<<<<< HEAD
        initViews();
        initClickListeners();

        myArrayList = User.getInstance().getUserFavorites();

        if(myArrayList == null)
            myArrayList = new ArrayList<>();

        myAdapter = new CustomAdapterFavorites(HomeScreenActivity.this, myArrayList);
        homeScreenListView.setAdapter(myAdapter);
    }

    private void initViews() {
=======
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
        mLogOut = (Button)findViewById(R.id.logOutButton);
        mMoreRestaurants = (Button)findViewById(R.id.search);
        homeScreenListView = (ListView)findViewById(R.id.FavoritesList);
        mTitle = (TextView)findViewById(R.id.FavoritesTitle);
        mGreeting = (TextView)findViewById(R.id.greetingsBanner);

        mFont = Typeface.createFromAsset(getAssets(), "fonts/AguafinaScript-Regular.ttf");
        mTitle.setTypeface(mFont);

<<<<<<< HEAD
        mGreeting.setText("Welcome back " + User.getInstance().getUserName());
    }

    private void initClickListeners() {
=======
        myArrayList = User.getInstance().getUserFavorites();

        if(myArrayList == null)
            myArrayList = new ArrayList<>();

        myAdapter = new CustomAdapterFavorites(HomeScreenActivity.this, myArrayList);
        homeScreenListView.setAdapter(myAdapter);

        mGreeting.setText("Welcome back " + User.getInstance().getUserName());

>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
        mMoreRestaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, RestaurantsListActivity.class);
                startActivity(intent);
            }
        });

        homeScreenListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mHelper = new RestaurantsSQLiteOpenHelper(HomeScreenActivity.this);
                Intent intent = new Intent(HomeScreenActivity.this, DetailActivity.class);
                Cursor cursor = mHelper.getRestaurantList();

<<<<<<< HEAD
                // -1 because of database offset
                cursor.moveToPosition(myArrayList.get(position).getRestaurantID() - 1);
=======
                /* -1 because of database offset */
                cursor.moveToPosition(myArrayList.get(position).getmRestaurantID() - 1);
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5

                intent.putExtra("id", cursor.getInt(cursor.getColumnIndex("_id")));
                startActivity(intent);
            }
        });


        /**
         * Brings up alert dialog to remove an item from the list.
         */

        homeScreenListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(HomeScreenActivity.this)
                        .setTitle("Delete Restaurant")
                        .setMessage("Are you sure you want to delete this Restaurant?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                myArrayList.remove(position);
                                myAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(HomeScreenActivity.this, "Won't delete", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                return true;
            }
        });
    }
<<<<<<< HEAD

    public void logout(View view) {
//        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor prefsEditor = mPrefs.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(User.getInstance()); // myObject - instance of MyObject
//        prefsEditor.putString(User.getInstance().getUserName(), json);
//        prefsEditor.commit();

        Intent intent = new Intent(HomeScreenActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void getUser() {

        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("MyObject", "");
        User user = gson.fromJson(json, User.class);
    }
=======
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
}
