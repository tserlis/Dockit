package com.example.tommy.dockittestapp;

/**
 * Created by Tommy on 06/03/2018.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.content.Intent.getIntent;

public class MenuTab1Starters extends Fragment {

    Button btnAddS1, btnAddS2, btnAddS3, btnAddS4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1_starters, container, false);


        btnAddS1 = rootView.findViewById(R.id.btnSItem1);
        btnAddS2 = rootView.findViewById(R.id.btnSItem2);
        btnAddS3 = rootView.findViewById(R.id.btnSItem3);
        btnAddS4 = rootView.findViewById(R.id.btnSItem4);


        /*btnAddS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                order.AddFood(btnAddS1.getText().toString(), 2, seatNumber);
            }
        });

        btnAddS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                order.AddFood(btnAddM2.getText().toString(), 2, seatNumber);
            }
        });

        btnAddS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                order.AddFood(btnAddM3.getText().toString(), 2, seatNumber);
            }
        });

        btnAddS4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                order.AddFood(btnAddM4.getText().toString(), 2,  seatNumber);
            }
        });*/
        return rootView;

    }
}
