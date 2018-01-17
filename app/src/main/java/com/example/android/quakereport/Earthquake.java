package com.example.android.quakereport;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pjsevilla on 15/01/2018.
 */

public class Earthquake {

    private final double mMagnitude;
    private final String mPlace;
    private final long mTimestamp;
    private final String mUrl;

    Earthquake(double magnitude, String place, long timestamp, String url) {
        mMagnitude = magnitude;
        mPlace = place;
        mTimestamp = timestamp;
        mUrl = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public long getTimestamp() {
        return mTimestamp;
    }

    public String getUrl() { return mUrl; }
}
