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

<<<<<<< HEAD
    private EditText mAccountName;
    private EditText mPassword;
=======
    EditText mAccountName;
    EditText mPassword;
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5

    UserSQLiteOpenHelper myUserDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mAccountName = (EditText)findViewById(R.id.accountName);
        mPassword = (EditText)findViewById(R.id.password);

<<<<<<< HEAD
=======

>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
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
<<<<<<< HEAD
=======

>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
            startActivity(intent);
        }
    }
}
