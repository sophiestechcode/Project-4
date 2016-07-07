package com.example.ruben.project4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockApplication;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;


import java.util.ArrayList;
import java.util.List;

public class BarChartt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchartt);

        BarChart  barChart = (BarChart) findViewById(R.id.chart);

        StolenBikesM1 stolenBikesM1 = ((RotterdamBikesApplication) getApplication()).getStolenBikesM1Data(this);
        List<StolenBikesM1.DistrictCount> groupedByDistrict = stolenBikesM1.getGroupedByDistrict();

        List<BarEntry> entries = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        int index = 0;
        for (StolenBikesM1.DistrictCount districtAndCount : groupedByDistrict) {
            labels.add(districtAndCount.district);
            entries.add(new BarEntry(districtAndCount.count, index++));
        }

        BarDataSet dataset = new BarDataSet(entries, "Aantal fietstrommels");
        BarData data = new BarData(labels, dataset);

        barChart.setData(data);
        barChart.animateY(5000);
        barChart.setDescription("");

    }
}
