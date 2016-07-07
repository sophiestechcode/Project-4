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
public class StolenBikesM1 implements Serializable {

    private final List<M1> stolenBikes;

    public StolenBikesM1(AppCompatActivity activity) {
        stolenBikes = new CsvReader(activity).readM1s();
    }

    public List<DistrictCount> getGroupedByDistrict() {
        Map<String, DistrictCount> countsByBrand = new HashMap<>();
        // Group counts by month
        for (M1 m1 : stolenBikes) {
            DistrictCount districtCount = countsByBrand.get(m1.getDeelgemeente());
            if (districtCount == null) {
                countsByBrand.put(m1.getDeelgemeente(), new DistrictCount(m1.getDeelgemeente()));
            } else {
                districtCount.count++;
            }
        }
        // Sort stolen bike districts
        List<DistrictCount> districtCounts = new ArrayList<>(countsByBrand.values());
        Collections.sort(districtCounts);

        // Get top 5 most stolen brands
        return districtCounts.subList(0, 5);
    }

    public static class DistrictCount implements Comparable<DistrictCount> {
        final String district;
        int count;

        public DistrictCount(String district) {
            this.district = district;
            this.count = 1;
        }

        @Override
        public int compareTo(DistrictCount another) {
            return another.count - count;
        }
    }
}
