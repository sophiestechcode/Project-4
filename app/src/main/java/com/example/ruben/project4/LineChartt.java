package com.example.ruben.project4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.components.Legend;

import java.util.ArrayList;
import java.util.List;

public class LineChartt extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linechartt);
//        Legend legend = chart.getlegend();
        LineChart lineChart = (LineChart) findViewById(R.id.chart);
        if (lineChart == null) {
            throw new RuntimeException("Could not find UI element 'R.id.chart'");
        }

        StolenBikesM2 stolenBikesM2 = ((RotterdamBikesApplication) getApplication()).getStolenBikesM2Data(this);
        List<StolenBikesM2.MonthlyCount> groupedByMonth = stolenBikesM2.getGroupedByMonth();

        List<Entry> entries = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        int index = 0;
        for (StolenBikesM2.MonthlyCount monthAndCount : groupedByMonth) {
            labels.add(monthAndCount.getMonthName());
            entries.add(new Entry(monthAndCount.count, index++));
        }

        LineDataSet dataset = new LineDataSet(entries, "Aantal gestolen fietsen per maand");
        LineData data = new LineData(labels, dataset);

        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        lineChart.setData(data);
        lineChart.animateY(2500);
        lineChart.setDescription("");
        lineChart.getAxisLeft().setDrawLabels(false);
        lineChart.getAxisRight().setDrawLabels(false);
        data.setValueTextSize(10);
    }
}
