package com.example.ruben.project4;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ruben.project4.data.FietsDiefstalData;
import com.example.ruben.project4.data.FietsTrommelData;

/**
 * Created by elif on 4-7-2016.
 */


public class RotterdamBikesApplication extends Application {
    private StolenBikesM1 stolenBikesM1;
    private StolenBikesM2 stolenBikesM2;
    private StolenBikesM4 stolenBikesM4;

    private FietsTrommelData fietsTrommelData;
    private FietsDiefstalData fietsDiefstalData;

    public FietsTrommelData getFietsTrommels(AppCompatActivity activity) {
        if (fietsTrommelData == null) {
            fietsTrommelData = new FietsTrommelData(activity);
        }
        return fietsTrommelData;
    }

    public FietsDiefstalData getFietsDiefstalData(AppCompatActivity activity) {
        if (fietsDiefstalData == null) {
            fietsDiefstalData = new FietsDiefstalData(activity);
        }
        return fietsDiefstalData;
    }

    public StolenBikesM1 getStolenBikesM1Data(AppCompatActivity activity) {
        if(stolenBikesM1 == null) {
            Log.i("Performance", "StolenBikesM1 was not found, this may cause performance issues.");
            stolenBikesM1 = new StolenBikesM1(activity);
        }
        return stolenBikesM1;
    }

    public StolenBikesM2 getStolenBikesM2Data(AppCompatActivity activity) {
        if(stolenBikesM2 == null) {
            Log.i("Performance", "StolenBikesM2 was not found, this may cause performance issues.");
            stolenBikesM2 = new StolenBikesM2(activity);
        }
        return stolenBikesM2;
    }

    public StolenBikesM4 getStolenBikesM4Data(AppCompatActivity activity) {
        if(stolenBikesM4 == null) {
            Log.i("Performance", "StolenBikesM4 was not found, this may cause performance issues.");
            stolenBikesM4 = new StolenBikesM4(activity);
        }
        return stolenBikesM4;
    }
}
