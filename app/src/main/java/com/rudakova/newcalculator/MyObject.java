package com.rudakova.newcalculator;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

public class MyObject implements Parcelable {

    final static String LOG_TAG = "myLogs";

    public ArrayList<String> list_result;

    // обычный конструктор
    public MyObject(ArrayList<String> address) {
        Log.d(LOG_TAG, "MyObject(String _s, int _i)");
        this.list_result = address;
    }

    public int describeContents() {
        return 0;
    }

    // упаковываем объект в Parcel
    public void writeToParcel(Parcel parcel, int flags) {
        Log.d(LOG_TAG, "writeToParcel");
        parcel.writeStringList(list_result);
    }

    public static final Parcelable.Creator<MyObject> CREATOR = new Parcelable.Creator<MyObject>() {
        // распаковываем объект из Parcel
        public MyObject createFromParcel(Parcel in) {
            Log.d(LOG_TAG, "createFromParcel");
            return new MyObject(in);
        }

        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };

    // конструктор, считывающий данные из Parcel
    private MyObject(Parcel parcel) {
        Log.d(LOG_TAG, "MyObject(Parcel parcel)");
        list_result = parcel.createStringArrayList();
    }

}