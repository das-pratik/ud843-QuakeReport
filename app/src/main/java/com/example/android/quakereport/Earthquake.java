package com.example.android.quakereport;

public class Earthquake {

    private String mLocation;
    private String mDate;
    private String mTime;
    private long mMag;

    public Earthquake(String location, String date, String time, long mag){
        mLocation = location;
        mDate = date;
        mTime = time;
        mMag = mag;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }

    public String getTime() {
        return mTime;
    }

    public long getMag() {
        return mMag;
    }
}
