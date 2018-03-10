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

public class TableActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    ImageButton btnHome;
    Button btnNext;
    EditText txtTabNum, txtCustNum;
    //Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);


        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        //linking screen elements to variables
        btnHome = findViewById(R.id.imBtnDockit);
        txtTabNum = findViewById(R.id.eTxtTabNum);
        txtCustNum = findViewById(R.id.eTxtCustNum);
        btnNext = findViewById(R.id.btnNext);

        //Logo Home button click event
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(TableActivity.this, HomeActivity.class));
            }
        });

        //Set click event for next button (transfer to position activity)
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pNum = Integer.parseInt(txtCustNum.getText().toString());
                int tNum = Integer.parseInt(txtTabNum.getText().toString());
                Order order = new Order(pNum, tNum);
                Intent nextPage = new Intent(TableActivity.this, PositionActivity.class);
                nextPage.putExtra("order", order);
                startActivity(nextPage);
            }
        });

        }
}
