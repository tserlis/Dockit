package com.example.tommy.dockittestapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Tommy on 31/01/2018.
 */

public class Order implements Parcelable{

    private int PERSONS_NUM = 0;
    private int TABLE_NUM = 0;
    private int PERSONS_ORDERED = 0;

    private String[][] orders;
    /* private String[][] orders =
                               [Starter] [Starter]
                               [Starter notes] [Starter notes]
                               [main] [main]
                               [main notes] [main notes]
                               [dessert] [dessert]
                               [dessert notes] [dessert notes]
                               [drinks] [drinks]
                               [drinks notes] [drinks notes]
       Column = seat num (e.g order[0][1] = seat number 1, stater)
                               */

    //Constructor for creation of first parcel
    public Order (int pNum, int tNum) {
        PERSONS_NUM = pNum;
        TABLE_NUM = tNum;
        orders = new String[pNum][8];
        for (int i = 0; i<pNum; i++) {
            for (int j = 0; j<8; j++) {
                orders[i][j] = "";
            }
        }
    }

    //Constructor for order when passed as parcel to new activity
    public Order (Parcel in) {
        PERSONS_NUM = in.readInt();
        TABLE_NUM = in.readInt();
        PERSONS_ORDERED = in.readInt();
        String[]compressedOrders = in.createStringArray();
        orders = toTwoDimensions(8, compressedOrders);
    }

    //Adds the food the person chose to the order
    public void AddFood(String foodOrder, int courseNum, int seatNum) {
        orders[seatNum-1][courseNum] = foodOrder;
    }

    //Returns true if every person has ordered
    public boolean orderComplete () {
        if (PERSONS_ORDERED == PERSONS_NUM) {
            return true;
        }
        else return false;
    }

    public String[] toOneDimension(String[][] input){
        String[] output = new String[input.length * input[0].length];

        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input[i].length; j++){
                output[i*j] = input[i][j];
            }
        }
        return output;
    }

    public String[][] toTwoDimensions(int dimensions, String[] input){
        String[][] output = new String[input.length / dimensions][dimensions];

        for(int i = 0; i < input.length; i++){
            output[i/dimensions][i % dimensions] = input[i];
        }
        return output;
    }

    //Returns the total number of people at table
    public int getNumOfPersons () {
        return PERSONS_NUM;
    }

    public int getTabNum () {
        return TABLE_NUM;
    }
    //Get the contents of the order (person and food ordered)
    public String getFood (int person, int courseNum) {
        return orders[person][courseNum];
    }

    //returns the number of the person who is currently ordering
    //also used in cart confirmation to get total number of people
    public int currentPerson() {
        return PERSONS_ORDERED;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //Writes object contents to parcel
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(PERSONS_NUM);
        parcel.writeInt(TABLE_NUM);
        parcel.writeInt(PERSONS_ORDERED);
        String[] compressedOrder = toOneDimension(orders);
        parcel.writeStringArray(compressedOrder);
    }

    public static final Parcelable.Creator<Order> CREATOR = new Parcelable.Creator<Order>() {
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        public Order[] newArray(int size) {
            return new Order[size];
        }
    };


}
