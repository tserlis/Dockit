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
import android.widget.ImageButton;
import android.widget.Toast;

public class PositionActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    ImageButton btnHome;
    Button btnNext;
    //Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position);



        //linking onscreen elements to objects
        btnHome = findViewById(R.id.imBtnDockit);
        btnNext = findViewById(R.id.btnNext);

        //Creating Home Button click event
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(PositionActivity.this, HomeActivity.class));
            }
        });

        //Next button click event
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //retrieving Order data
                Order order = (Order) getIntent().getParcelableExtra("order");
                Intent next = new Intent (PositionActivity.this, MenuActivity.class);
                next.putExtra("order", order);
                finish();
                startActivity(next);
            }
        });

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

    }
}
