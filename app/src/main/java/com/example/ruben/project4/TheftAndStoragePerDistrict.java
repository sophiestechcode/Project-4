package com.example.ruben.project4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class TheftAndStoragePerDistrict extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theftandstorageperdistrict);

        RotterdamDistricts selectedDistrict =
                (RotterdamDistricts) getIntent().getSerializableExtra("selectedDistrict");
        if (selectedDistrict == null) {
            Intent intent = new Intent(this, DistrictSelectionActivity.class);
            startActivity(intent);
            return;
        }

        TextView textField = (TextView) findViewById(R.id.selectedDistrictText);
        if (textField == null) {
            throw new RuntimeException("TextField could not be found, check activity xml file");
        }
        textField.setText(String.format("Aantal fietstrommels tegenover aantal fietsdiefstallen in %s.", selectedDistrict.trommelText));

        ContextCompat.getColor(this, R.color.blue);
        ContextCompat.getColor(this, R.color.red);
        BarChart barChart = (BarChart) findViewById(R.id.chart);
        if (barChart == null) {
            throw new RuntimeException("BarChart could not be found, check activity xml file");
        }

        RotterdamBikesApplication application = (RotterdamBikesApplication) getApplication();

        double[] trommels = application.getFietsTrommels(this).getMonthlyCountsForDistrict(selectedDistrict.trommelText);
        ArrayList<BarEntry> trommellen = new ArrayList<>();
        for (int i = 0; i < trommels.length; i++) {
            trommellen.add(new BarEntry((float) trommels[i], i));
        }

        double[] diefstal = application.getFietsDiefstalData(this).getMonthlyCountsForDistrict(selectedDistrict.diefstalText);
        ArrayList<BarEntry> diefstallen = new ArrayList<>();
        for (int i = 0; i < diefstal.length; i++) {
            diefstallen.add(new BarEntry((float) diefstal[i], i));
        }

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Januari");
        labels.add("februari");
        labels.add("Maart");
        labels.add("April");
        labels.add("Mei");
        labels.add("Juni");
        labels.add("Juli");
        labels.add("Augustus");
        labels.add("September");
        labels.add("Oktober");
        labels.add("November");
        labels.add("December");

        BarDataSet barDataSet1 = new BarDataSet(trommellen, "fietstrommels");
        barDataSet1.setColors(new int []{R.color.red},this);
        BarDataSet barDataSet2 = new BarDataSet(diefstallen, "fietsdiefstallen");
        barDataSet2.setColors(new int[]{R.color.blue},this);

        ArrayList<IBarDataSet> datasets = new ArrayList<>();
        datasets.add(barDataSet1);
        datasets.add(barDataSet2);

        BarData data = new BarData(labels,datasets);
        barChart.setData(data);
        barChart.setDescription(" ");
        barChart.setDescriptionPosition(800f, 10f);
    }
}
