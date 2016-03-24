package com.example.jamieayer.project2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Project2.Databases.UserSQLiteOpenHelper;
import Project2.Objects.User;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    /**
     * Login or create account
     */

    private EditText mUserName;
    private EditText mPassword;
    private TextView mAppTitle;
    private Typeface mFont;

    public UserSQLiteOpenHelper myUserDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Neighborhood Restaurants");

        mUserName = (EditText)findViewById(R.id.userNameEditText);
        mPassword = (EditText)findViewById(R.id.userPassword);

        mAppTitle = (TextView)findViewById(R.id.appTitle);
        mFont = Typeface.createFromAsset(getAssets(), "fonts/AguafinaScript-Regular.ttf");
        mAppTitle.setTypeface(mFont);
        mAppTitle.setShadowLayer(1, 0, 0, Color.BLACK);

        myUserDB = UserSQLiteOpenHelper.getInstance(this);
    }

    /**
     * Checks if both user name and password are in the user DB in the same row.
     * @param view
     */

    public void login(View view) {
        if (mUserName.getText().toString().trim().equalsIgnoreCase("")) {
            mUserName.setError("Must Enter Name");
        }

        if (mPassword.getText().toString().trim().equalsIgnoreCase("")) {
            mPassword.setError("Must Enter Password");
        }

        Log.d(TAG, "login: "+UserSQLiteOpenHelper.getInstance(this).CheckIfUserInDB(mUserName.getText().toString(),
                mPassword.getText().toString()));

        if(!UserSQLiteOpenHelper.getInstance(this).CheckIfUserInDB(mUserName.getText().toString(),
                mPassword.getText().toString())) {
            Toast.makeText(MainActivity.this, "Incorrect Information", Toast.LENGTH_SHORT).show();
            mUserName.setError("Incorrect Information");
        }

        else {
            Intent intent = new Intent(MainActivity.this, HomeScreenActivity.class);
            User.getInstance().setUserName(mUserName.getText().toString());
            User.getInstance().setUserPassword(mPassword.getText().toString());

            startActivity(intent);
        }
    }

    public void createAccount(View view) {
        Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void checkUsers(View view) {
        Intent intent = new Intent(MainActivity.this, CheckUsersActivity.class);
        startActivity(intent);
    }
}


