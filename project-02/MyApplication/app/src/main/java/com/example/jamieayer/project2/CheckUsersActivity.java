package com.example.jamieayer.project2;

import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import Project2.Adapters.CursorAdapterUsers;
import Project2.Databases.UserSQLiteOpenHelper;

/**
 * Created by JamieAyer on 3/22/16.
 */
public class CheckUsersActivity extends AppCompatActivity {

    CursorAdapter customAdapter;
    private Cursor mCursor;
    private ListView listView;
    private TextView mCheckUsersTitle;
    private Typeface mFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_users);


        listView = (ListView)findViewById(R.id.usersListView);
        mCheckUsersTitle = (TextView)findViewById(R.id.currentUsers);

        mFont = Typeface.createFromAsset(getAssets(), "fonts/lobster.otf");
        mCheckUsersTitle.setTypeface(mFont);

        mCursor = UserSQLiteOpenHelper.getInstance(this).getUserList();
        customAdapter = new CursorAdapterUsers(this, mCursor, 0);

        listView.setAdapter(customAdapter);
    }
}
