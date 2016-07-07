package com.example.ruben.project4.data;

import android.support.v7.app.AppCompatActivity;

import com.example.ruben.project4.CsvReader;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by elif on 05/07/16.
 */
public class FietsTrommelData {
    List<FietsTrommel> fietsTrommels;
    Set<String> districts;

    public FietsTrommelData(AppCompatActivity activity) {
        fietsTrommels = new CsvReader(activity).readFietsTrommels();
        districts = new TreeSet<>();
        for (FietsTrommel ft : fietsTrommels) {
            districts.add(ft.getDistrict());
        }
    }

    public Set<String> getDistricts() {
        return districts;
    }

    public double[] getMonthlyCountsForDistrict(String districtName) {
        double[] counts = new double[12];
        for (FietsTrommel fietsTrommel : fietsTrommels) {
            if (fietsTrommel.getDistrict().equalsIgnoreCase(districtName)) {
                counts[fietsTrommel.getInstallationDate().getMonth()]++;
            }
        }
        return counts;
    }
}
