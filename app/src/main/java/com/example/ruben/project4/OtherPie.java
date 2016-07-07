package com.example.ruben.project4;

import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

public class OtherPie extends AbstractPieChartActivity {
    PieChart grafiek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_pie);

        grafiek = (PieChart) findViewById(R.id.piechart);

        StolenBikesM4 stolenBikes = ((RotterdamBikesApplication) getApplication()).getStolenBikesM4Data(this);
        LabelsAndEntries labelsAndEntries = createPieData(stolenBikes.getGroupedByColor(), stolenBikes.getTotal());

        PieDataSet dataset = new PieDataSet(labelsAndEntries.entries, "");
        PieData data = new PieData(labelsAndEntries.labels, dataset);

        Legend legend = grafiek.getLegend();
        grafiek.setData(data);
        grafiek.setHoleRadius(50f);
        grafiek.setTransparentCircleRadius(0f);
        grafiek.setDescription("");
        grafiek.animateY(1000);
        grafiek.setCenterText("%");
        grafiek.setCenterTextSizePixels(200f);
        dataset.setValueTextSize(10f);
        dataset.setColors(new int[]{
                        R.color.pie_2_1, R.color.pie_2_2, R.color.pie_2_3,
                        R.color.pie_2_4, R.color.pie_2_5, R.color.pie_2_6, R.color.pie_2_7},
                this);
        legend.setWordWrapEnabled(true);
    }
}
