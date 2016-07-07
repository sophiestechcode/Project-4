package com.example.ruben.project4;

import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by elif on 4-7-2016.
 */


public class StolenBikesM2 implements Serializable {

    private final List<M2> stolenBikes;

    public StolenBikesM2(AppCompatActivity activity) {
        stolenBikes = new CsvReader(activity).readM2s();
    }

    public List<MonthlyCount> getGroupedByMonth() {
        Map<Integer, MonthlyCount> countsByBrand = new HashMap<>();
        // Group counts by month
        for (M2 m2 : stolenBikes) {
            MonthlyCount monthlyCount = countsByBrand.get(m2.getGemiddelde_maand());
            if (monthlyCount == null) {
                countsByBrand.put(m2.getGemiddelde_maand(), new MonthlyCount(m2.getGemiddelde_maand()));
            } else {
                monthlyCount.count++;
            }
        }
        // Get top 5 most stolen brands
        List<MonthlyCount> monthlyCounts = new ArrayList<>(countsByBrand.values());
        Collections.sort(monthlyCounts);

        return monthlyCounts;
    }

    public static class MonthlyCount implements Comparable<MonthlyCount> {
        final int month;
        int count;

        public MonthlyCount(int month) {
            this.month = month;
            this.count = 1;
        }

        @Override
        public int compareTo(MonthlyCount another) {
            return month - another.month;
        }

        public String getMonthName() {
            switch (month) {
                case 1:
                    return "Jan";
                case 2:
                    return "Feb";
                case 3:
                    return "Mar";
                case 4:
                    return "Apr";
                case 5:
                    return "May";
                case 6:
                    return "Jun";
                case 7:
                    return "Jul";
                case 8:
                    return "Aug";
                case 9:
                    return "Sep";
                case 10:
                    return "Oct";
                case 11:
                    return "Nov";
                case 12:
                    return "Dec";
            }
            throw new RuntimeException("Unexpected month value: " + month);
        }
    }
}
