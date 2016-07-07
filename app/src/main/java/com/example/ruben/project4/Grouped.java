package com.example.ruben.project4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class Grouped extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grouped);

        BarChart barChart = (BarChart) findViewById(R.id.chart);
        ArrayList<BarEntry> trommels = new ArrayList<>();
        trommels.add(new BarEntry(88f, 0));
        trommels.add(new BarEntry(43f, 1));
        trommels.add(new BarEntry(168f, 2));
        trommels.add(new BarEntry(78f, 3));
        trommels.add(new BarEntry(14f, 4));
        trommels.add(new BarEntry(1f, 5));
        trommels.add(new BarEntry(1f, 6));
        trommels.add(new BarEntry(56f, 7));
        trommels.add(new BarEntry(220f, 8));
        trommels.add(new BarEntry(1f, 9));
        trommels.add(new BarEntry(28f, 10));
        trommels.add(new BarEntry(2f, 11));
        trommels.add(new BarEntry(2f, 12));

        ArrayList<BarEntry> diefstallen = new ArrayList<>();
        diefstallen.add(new BarEntry(1681f, 0));
        diefstallen.add(new BarEntry(830f, 1));
        diefstallen.add(new BarEntry(147f, 2));
        diefstallen.add(new BarEntry(409f, 3));
        diefstallen.add(new BarEntry(446f, 4));
        diefstallen.add(new BarEntry(580f, 5));
        diefstallen.add(new BarEntry(481f, 6));
        diefstallen.add(new BarEntry(1029f, 7));
        diefstallen.add(new BarEntry(1259f, 8));
        diefstallen.add(new BarEntry(91f, 9));
        diefstallen.add(new BarEntry(185f, 10));
        diefstallen.add(new BarEntry(57f, 11));
        diefstallen.add(new BarEntry(1306f, 12));

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Centrum");
        labels.add("Charlois");
        labels.add("Delfshaven");
        labels.add("Feijenoord");
        labels.add("Hillegersberg");
        labels.add("Hoogvliet");
        labels.add("Ijselmonde");
        labels.add("Kralingen/Crooswijk");
        labels.add("Noord");
        labels.add("Ommoord");
        labels.add("Overschie");
        labels.add("Pernis");
        labels.add("West");

        BarDataSet barDataSet1 = new BarDataSet(trommels, "fietstrommels");
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);
        BarDataSet barDataSet2 = new BarDataSet(diefstallen, "fietsdiefstallen");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        ArrayList<IBarDataSet> datasets = new ArrayList<>();
        datasets.add(barDataSet1);
        datasets.add(barDataSet2);


        BarData data = new BarData(labels,datasets);
        barChart.setData(data);


    }

}
