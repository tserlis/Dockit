package com.example.tommy.dockittestapp;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteOpenHelper OpenHelper;
    SQLiteDatabase db;
    Button btnRegister, btnLogin;
    EditText txtFName, txtLName, txtEmail, txtUsername, txtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check if user is already logged in, and if they are, sends user to the home page
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, HomeActivity.class));
        }

        //setting up database helper
        OpenHelper = new DatabaseHelper(this);

        //linking objects to screen elements
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
        txtFName = findViewById(R.id.eTxtFName);
        txtLName = findViewById(R.id.eTxtLName);
        txtEmail = findViewById(R.id.eTxtEmail);
        txtUsername = findViewById(R.id.eTxtUsername);
        txtPassword = findViewById(R.id.eTxtPassword);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Converting user input to strings and inserting into database
                db = OpenHelper.getWritableDatabase();
                String fName = txtFName.getText().toString();
                String lName = txtLName.getText().toString();
                String email = txtEmail.getText().toString().trim();
                String username = txtUsername.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                insertData(fName, lName, email, username, password);
                Toast.makeText(getApplicationContext(), "Registered successfully",
                        Toast.LENGTH_LONG).show();


            }
        });

        //Setting click event for login button (change to login screen)
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

    }


    //Function that inserts the inputted user data into the database
    public void insertData(String fName, String lName, String email, String username,
                           String password) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, fName);
        contentValues.put(DatabaseHelper.COL_3, lName);
        contentValues.put(DatabaseHelper.COL_4, email);
        contentValues.put(DatabaseHelper.COL_5, username);
        contentValues.put(DatabaseHelper.COL_6, password);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);

    }
}
