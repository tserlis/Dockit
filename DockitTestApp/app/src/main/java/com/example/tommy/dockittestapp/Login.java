package com.example.tommy.dockittestapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button btnLogin;
    EditText txtEmail, txtPassword;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Check if user is already logged in, and if they are, sends user to the home page
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, HomeActivity.class));
        }

        //getting a readable database to check if login details are correct
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        //linking objects with screen elements
        btnLogin = findViewById(R.id.btnLogin);
        txtEmail = findViewById(R.id.eTxtEmail);
        txtPassword = findViewById(R.id.eTxtPassword);

        //Setting login button click event
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Converting user input to strings
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                //checking strings against database
                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME +
                    " WHERE " + DatabaseHelper.COL_4 + "=? AND " + DatabaseHelper.COL_6 +
                    "=? ", new String[] {email, password});
                if (cursor != null) {
                    if(cursor.getCount() > 0) {
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
                        SharedPrefManager.getInstance(
                                getApplicationContext()).userLogin(cursor.getInt(0),
                                cursor.getString(1), cursor.getString(2),
                                cursor.getString(3), cursor.getString(4), cursor.getString(5));
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
