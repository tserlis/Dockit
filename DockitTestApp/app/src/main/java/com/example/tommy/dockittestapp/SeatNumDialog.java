package com.example.tommy.dockittestapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Tommy on 15/03/2018.
 */

public class SeatNumDialog extends AppCompatDialogFragment {

    private EditText eTxtSeatNum;
    private SeatNumDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view).setTitle("Seat Number").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int seatNum = Integer.parseInt(eTxtSeatNum.getText().toString());
                listener.applyText(seatNum);
            }
        });

        eTxtSeatNum = view.findViewById(R.id.eTxtSeatNum);
        return builder.create();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (SeatNumDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement SeatNumDialogListener");
        }


    }

    public interface SeatNumDialogListener {
        void applyText(int seatNum);
    }
}
