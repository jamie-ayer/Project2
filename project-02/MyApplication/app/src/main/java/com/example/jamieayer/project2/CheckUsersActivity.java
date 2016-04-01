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

<<<<<<< HEAD
    private CursorAdapter customAdapter;
=======
    CursorAdapter customAdapter;
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
    private Cursor mCursor;
    private ListView listView;
    private TextView mCheckUsersTitle;
    private Typeface mFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_users);

<<<<<<< HEAD
        initViews();

        mCursor = UserSQLiteOpenHelper.getInstance(this).getUserList();
        customAdapter = new CursorAdapterUsers(this, mCursor, 0);

        listView.setAdapter(customAdapter);
    }

    private void initViews() {
=======

>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
        listView = (ListView)findViewById(R.id.usersListView);
        mCheckUsersTitle = (TextView)findViewById(R.id.currentUsers);

        mFont = Typeface.createFromAsset(getAssets(), "fonts/lobster.otf");
        mCheckUsersTitle.setTypeface(mFont);
<<<<<<< HEAD
=======

        mCursor = UserSQLiteOpenHelper.getInstance(this).getUserList();
        customAdapter = new CursorAdapterUsers(this, mCursor, 0);

        listView.setAdapter(customAdapter);
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
    }
}
