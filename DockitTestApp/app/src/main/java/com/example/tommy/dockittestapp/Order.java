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
    private String[] food;

    private String[][] orders;

    //Constructor for creation of first parcel
    public Order (int pNum, int tNum) {
        PERSONS_NUM = pNum;
        TABLE_NUM = tNum;
        food = new String[pNum];
        for (int i = 0; i<food.length; i++) {
            food[i] = "";
        }
    }

    //Constructor for order when passed as parcel to new activity
    public Order (Parcel in) {
        PERSONS_NUM = in.readInt();
        TABLE_NUM = in.readInt();
        PERSONS_ORDERED = in.readInt();
        food = in.createStringArray();
    }

    //Adds the food the person chose to the order
    public void AddFood(String foodOrder, int person) {
        food[person] = foodOrder;
        PERSONS_ORDERED++;
    }

    //Returns true if every person has ordered
    public boolean orderComplete () {
        if (PERSONS_ORDERED == PERSONS_NUM) {
            return true;
        }
        else return false;
    }

    //Returns the total number of people at table
    public int getNumOfPersons () {
        return PERSONS_NUM;
    }

    public int getTabNum () {
        return TABLE_NUM;
    }
    //Get the contents of the order (person and food ordered)
    public String getFood (int person) {
        return food[person];
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
        parcel.writeStringArray(food);
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
