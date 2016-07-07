package com.example.ruben.project4;

import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPieChartActivity extends AppCompatActivity {

    LabelsAndEntries createPieData(List<StolenBikesM4.GroupAndCount> groupsAndCounts, float total) {
        int index;
        float countedPercentages = 0f;

        ArrayList<String> labels = new ArrayList<>();
        List<Entry> entries = new ArrayList<>();
        for (index = 0; index < 5; index++) {
            labels.add(groupsAndCounts.get(index).group);
            float percentage = convertToPercent(groupsAndCounts.get(index).count / total);
            entries.add(new Entry(percentage, index));

            countedPercentages += percentage;
        }

        // Add remaining percentage
        labels.add("Overig");
        entries.add(new Entry(100 - countedPercentages, index));

        return new LabelsAndEntries(labels, entries);
    }

    private float convertToPercent(float value) {
        // Value is something like 0.12345 and we want to display values like 12.3
        return (Math.round(value * 1000)) / 10f;
    }

    class LabelsAndEntries {
        final List<String> labels;
        final List<Entry> entries;

        public LabelsAndEntries(List<String> labels, List<Entry> entries) {
            this.labels = labels;
            this.entries = entries;
        }
    }
}
