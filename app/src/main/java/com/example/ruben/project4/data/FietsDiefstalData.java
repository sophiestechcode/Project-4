package com.example.ruben.project4.data;

import android.support.v7.app.AppCompatActivity;

import com.example.ruben.project4.CsvReader;

import java.util.List;

/**
 * Created by elif on 05/07/16.
 */
public class FietsDiefstalData {

    List<FietsDiefstal> fietsDiefstals;

    public FietsDiefstalData(AppCompatActivity activity) {
        fietsDiefstals = new CsvReader(activity).readFietsDiefstal();
    }

    public double[] getMonthlyCountsForDistrict(String districtName) {
        double[] counts = new double[12];
        for (FietsDiefstal fietsDiefstal : fietsDiefstals) {
            if (fietsDiefstal.getDistrict().equalsIgnoreCase(districtName)) {
                counts[fietsDiefstal.getNoticeDate().getMonth()]++;
            }
        }
        return counts;
    }

}
