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

public class MenuTab2Mains extends Fragment {

    Button btnAddM1, btnAddM2, btnAddM3, btnAddM4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2_main, container, false);
        btnAddM1 = rootView.findViewById(R.id.btnMItem1);
        btnAddM2 = rootView.findViewById(R.id.btnMItem2);
        btnAddM3 = rootView.findViewById(R.id.btnMItem3);
        btnAddM4 = rootView.findViewById(R.id.btnMItem4);

        /*btnAddM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                order.AddFood(btnAddM1.getText().toString(), 2, seatNumber);
            }
        });

        btnAddM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                order.AddFood(btnAddM2.getText().toString(), 2, seatNumber);
            }
        });

        btnAddM3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                order.AddFood(btnAddM3.getText().toString(), 2, seatNumber);
            }
        });

        btnAddM4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                order.AddFood(btnAddM4.getText().toString(), 2,  seatNumber);
            }
        });*/
        return rootView;
    }
}
