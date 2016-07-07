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
public class StolenBikesM4 implements Serializable {

    private final List<M4> stolenBikes;

    public StolenBikesM4(AppCompatActivity activity) {
        stolenBikes = new CsvReader(activity).readM4s();
    }

    public int getTotal() {
        return stolenBikes.size();
    }

    public List<GroupAndCount> getGroupedByBrand() {
        Map<String, GroupAndCount> countsByBrand = new HashMap<>();
        // Group counts by month
        for (M4 m4 : stolenBikes) {
            GroupAndCount groupAndCount = countsByBrand.get(m4.getMerk());
            if (groupAndCount == null) {
                countsByBrand.put(m4.getMerk(), new GroupAndCount(m4.getMerk()));
            } else {
                groupAndCount.count++;
            }
        }
        // Get top 5 most stolen brands
        List<GroupAndCount> groupAndCounts = new ArrayList<>(countsByBrand.values());
        Collections.sort(groupAndCounts);

        return groupAndCounts;
    }

    public List<GroupAndCount> getGroupedByColor() {
        Map<String, GroupAndCount> countsByColor = new HashMap<>();
        // Group counts by month
        for (M4 m4 : stolenBikes) {
            GroupAndCount groupAndCount = countsByColor.get(m4.getKleur());
            if (groupAndCount == null) {
                countsByColor.put(m4.getKleur(), new GroupAndCount(m4.getKleur()));
            } else {
                groupAndCount.count++;
            }
        }
        // Get top 5 most stolen brands
        List<GroupAndCount> groupAndCounts = new ArrayList<>(countsByColor.values());
        Collections.sort(groupAndCounts);

        return groupAndCounts;
    }

    public static class GroupAndCount implements Comparable<GroupAndCount>, Serializable {
        final String group;
        int count;

        public GroupAndCount(String group) {
            this.group = group;
            this.count = 1;
        }

        @Override
        public int compareTo(GroupAndCount another) {
            return another.count - count;
        }
    }
}
