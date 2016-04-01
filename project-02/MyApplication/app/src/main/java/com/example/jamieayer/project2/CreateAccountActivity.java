package com.example.jamieayer.project2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import Project2.Databases.UserSQLiteOpenHelper;

/**
 * Created by JamieAyer on 3/22/16.
 */
public class CreateAccountActivity extends AppCompatActivity {

    private EditText mAccountName;
    private EditText mPassword;

    UserSQLiteOpenHelper myUserDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mAccountName = (EditText)findViewById(R.id.accountName);
        mPassword = (EditText)findViewById(R.id.password);

    }

    public void create(View view) {

        if (mAccountName.getText().toString().trim().equalsIgnoreCase(""))
            mAccountName.setError("Must Enter Name");
        if (mPassword.getText().toString().trim().equalsIgnoreCase(""))
            mPassword.setError("Must Enter Password");
        else {

            myUserDB = UserSQLiteOpenHelper.getInstance(this);
            myUserDB.insert(mAccountName.getText().toString(), mPassword.getText().toString());

            Intent intent = new Intent(CreateAccountActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
