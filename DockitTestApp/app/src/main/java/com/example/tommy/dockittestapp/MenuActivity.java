package com.example.tommy.dockittestapp;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends FragmentActivity implements ActionBar.TabListener {

    //android.app.ActionBar actionbar;
    ImageButton btnHome;
    TextView txtToast, txtNotToast, txtPNum;
    Button btnAddToast, btnAddNotToast, btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
       // actionbar = getActionBar();
        //actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //actionbar.addTab(actionbar.newTab().setText("Java").setTabListener(this));


        //retrieving Order data
        final Order order = (Order) getIntent().getParcelableExtra("order");

        //Linking objects to onscreen elements
        txtToast = findViewById(R.id.txtToast);
       // txtNotToast = findViewById(R.id.txtNotToast);
        txtPNum = findViewById(R.id.txtPNum);
        btnHome = findViewById(R.id.imBtnDockit);
        btnAddToast = findViewById(R.id.btnMItem1);
        btnAddNotToast = findViewById(R.id.btnAddNotToast);
        btnNext = findViewById(R.id.btnNext);

        //setting the person number to correct person
        final int currentPerson = order.currentPerson()+1;
        final int totalNumOfPersons = order.getNumOfPersons();
        String newPNum = currentPerson + " of " + totalNumOfPersons;
        txtPNum.setText(newPNum);



        //Home button click events
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(MenuActivity.this, HomeActivity.class));
            }
        });

        //Add Toast button click event
        btnAddToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  order.AddFood(txtToast.getText().toString(), order.currentPerson());
                Toast.makeText(getApplicationContext(), "Toast added to cart", Toast.LENGTH_LONG).show();
                Intent next;
                if (currentPerson < totalNumOfPersons) {
                    next = new Intent(MenuActivity.this, MenuActivity.class);
                }
                else {
                    next = new Intent(MenuActivity.this, CartConfirmActivity.class);
                }
                next.putExtra("order", order);
                startActivity(next);

            }
        });

        //Add Not Toast button click event
        btnAddNotToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //order.AddFood(txtNotToast.getText().toString(), order.currentPerson());
                Toast.makeText(getApplicationContext(), "Not toast added to cart", Toast.LENGTH_LONG).show();
                Intent next;
                if (currentPerson < totalNumOfPersons) {
                    next = new Intent(MenuActivity.this, MenuActivity.class);
                }
                else {
                    next = new Intent(MenuActivity.this, CartConfirmActivity.class);
                }
                next.putExtra("order", order);
                startActivity(next);

            }
        });

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}

