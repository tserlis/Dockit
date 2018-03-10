package com.example.tommy.dockittestapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CartConfirmActivity extends AppCompatActivity {

    ImageButton btnHome;
    Button btnConfirm;
    //declaring textviews to display person number and order
    TextView txtP1, txtP2, txtP3, txtP4, txtTabNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_confirm);

        //retrieving Order data
        Order order = (Order) getIntent().getParcelableExtra("order");

        //Linking objects to onscreen elements
        btnHome = findViewById(R.id.imBtnDockit);
        txtP1 = findViewById(R.id.txtP1);
        txtP2 = findViewById(R.id.txtP2);
        txtP3 = findViewById(R.id.txtP3);
        txtP4 = findViewById(R.id.txtP4);
        txtTabNum = findViewById(R.id.txtTabNum);
        btnConfirm = findViewById(R.id.btnConfirm);

        int numOfPeople = order.currentPerson();

        //Filling out order confirmation text fields
        String orderConfirm = "Person 1: " + order.getFood(0);
        txtP1.setText(orderConfirm);

        if (numOfPeople>=2) {
            orderConfirm = "Person 2: " + order.getFood(1);
            txtP2.setText(orderConfirm);
        }

        if (numOfPeople>=3) {
            orderConfirm = "Person 3: " + order.getFood(2);
            txtP3.setText(orderConfirm);
        }

        if (numOfPeople>=4) {
            orderConfirm = "Person 4: " + order.getFood(3);
            txtP4.setText(orderConfirm);
        }

        //Displaying table number
        String table = "Table " + order.getTabNum();
        txtTabNum.setText(table);


        //Setting Home button click event
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(CartConfirmActivity.this, HomeActivity.class));
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Toast.makeText(getApplicationContext(), "Order Completed!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(CartConfirmActivity.this, HomeActivity.class));
            }
        });
    }
}
