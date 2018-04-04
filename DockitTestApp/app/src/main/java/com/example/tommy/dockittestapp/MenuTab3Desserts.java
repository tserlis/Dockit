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

public class MenuTab3Desserts extends Fragment {
    Button btnAddD1, btnAddD2, btnAddD3, btnAddD4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3_desserts, container, false);
        btnAddD1 = rootView.findViewById(R.id.btnDItem1);
        btnAddD2 = rootView.findViewById(R.id.btnDItem2);
        btnAddD3 = rootView.findViewById(R.id.btnDItem3);
        btnAddD4 = rootView.findViewById(R.id.btnDItem4);

        /*btnAddD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                order.AddFood(btnAddD1.getText().toString(), 4, seatNumber);
            }
        });

        btnAddD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                order.AddFood(btnAddD2.getText().toString(), 4, seatNumber);
            }
        });

        btnAddD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                order.AddFood(btnAddD3.getText().toString(), 4, seatNumber);
            }
        });

        btnAddD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                order.AddFood(btnAddD4.getText().toString(), 4, seatNumber);
            }
        });*/
        return rootView;
    }
}
