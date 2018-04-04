package com.example.tommy.dockittestapp;

/**
 * Created by Tommy on 06/03/2018.
 */

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MenuTab4Order extends Fragment {
    Button btnOrderConfirm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab4_order, container, false);
        btnOrderConfirm = rootView.findViewById(R.id.btnConfirm);

        //btn click events



       /* btnOrderConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Order Completed!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(newMenuActivity.this, HomeActivity.class));
            }
        });*/
        return rootView;
    }
}
