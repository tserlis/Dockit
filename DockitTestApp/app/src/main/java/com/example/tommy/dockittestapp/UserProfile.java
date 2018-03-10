package com.example.tommy.dockittestapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfile extends AppCompatActivity {

    SQLiteOpenHelper openHelper = new DatabaseHelper(this);
    SQLiteDatabase db;
    ImageButton btnHome;
    Button btnSave;

    private EditText txtUsername, txtEmail, txtFName, txtLName, txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, Login.class));
        }

        //Linking objects to screen elements
        btnSave = findViewById(R.id.btnSaveChanges);
        txtUsername = findViewById(R.id.txtUsername);
        txtEmail = findViewById(R.id.txtEmail);
        txtFName = findViewById(R.id.txtFName);
        txtLName = findViewById(R.id.txtLName);
        txtPassword = findViewById(R.id.txtPassword);

        //linking the logo home button and creating its click event
        btnHome = findViewById(R.id.imBtnDockit);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(UserProfile.this, HomeActivity.class));
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTable(txtFName.getText().toString(), txtLName.getText().toString(), txtUsername.getText().toString().trim(), txtEmail.getText().toString(), txtPassword.getText().toString().trim());
            }
        });

        //setting text of fields by retrieving what is stored in the shared pref manager
        txtUsername.setText(SharedPrefManager.getInstance(this).getUsername());
        txtEmail.setText(SharedPrefManager.getInstance(this).getUserEmail());
        txtFName.setText(SharedPrefManager.getInstance(this).getFName());
        txtLName.setText(SharedPrefManager.getInstance(this).getLName());
        txtPassword.setText(SharedPrefManager.getInstance(this).getPassword());

    }

    //updates the data held in the database
    public void updateTable(String fName, String lName, String username, String email, String password) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COL_2, fName);
        cv.put(DatabaseHelper.COL_3, lName);
        cv.put(DatabaseHelper.COL_4, email);
        cv.put(DatabaseHelper.COL_5, username);
        cv.put(DatabaseHelper.COL_6, password);
        db = openHelper.getWritableDatabase();
        db.update(DatabaseHelper.TABLE_NAME, cv, "id="+SharedPrefManager.getInstance(this).getID(), null);
        SharedPrefManager.getInstance(this).userLogin(SharedPrefManager.getInstance(this).getID(), fName, lName, email, username, password);
        Toast.makeText(getApplicationContext(), "Changes saved!", Toast.LENGTH_LONG).show();
    }

}
