package com.example.jamieayer.project2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
<<<<<<< HEAD
=======
import android.support.v7.app.ActionBar;
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Project2.Databases.UserSQLiteOpenHelper;
import Project2.Objects.User;

<<<<<<< HEAD
/**
 * Login or create account
 */

=======
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

<<<<<<< HEAD
=======
    /**
     * Login or create account
     */

>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
    private EditText mUserName;
    private EditText mPassword;
    private TextView mAppTitle;
    private Typeface mFont;

    public UserSQLiteOpenHelper myUserDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        initViews();
=======
        setTitle("Neighborhood Restaurants");

        mUserName = (EditText)findViewById(R.id.userNameEditText);
        mPassword = (EditText)findViewById(R.id.userPassword);

        mAppTitle = (TextView)findViewById(R.id.appTitle);
        mFont = Typeface.createFromAsset(getAssets(), "fonts/AguafinaScript-Regular.ttf");
        mAppTitle.setTypeface(mFont);
        mAppTitle.setShadowLayer(1, 0, 0, Color.BLACK);
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5

        myUserDB = UserSQLiteOpenHelper.getInstance(this);
    }

    /**
<<<<<<< HEAD
     * Checks if both user name and password are in the user DB and in the same row.
=======
     * Checks if both user name and password are in the user DB in the same row.
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
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
<<<<<<< HEAD
            User.getInstance().setUserName(mUserName.getText().toString());
            User.getInstance().setUserPassword(mPassword.getText().toString());

            nextActivity(HomeScreenActivity.class);
=======
            Intent intent = new Intent(MainActivity.this, HomeScreenActivity.class);
            User.getInstance().setUserName(mUserName.getText().toString());
            User.getInstance().setUserPassword(mPassword.getText().toString());

            startActivity(intent);
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
        }
    }

    public void createAccount(View view) {
<<<<<<< HEAD
        nextActivity(CreateAccountActivity.class);
    }

    public void checkUsers(View view) {
        nextActivity(CheckUsersActivity.class);
    }

    private void initViews() {
        mUserName = (EditText)findViewById(R.id.userNameEditText);
        mPassword = (EditText)findViewById(R.id.userPassword);
    }

    private void nextActivity(Class classToLaunch) {
        startActivity(new Intent(MainActivity.this, classToLaunch));
=======
        Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void checkUsers(View view) {
        Intent intent = new Intent(MainActivity.this, CheckUsersActivity.class);
        startActivity(intent);
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
    }
}


