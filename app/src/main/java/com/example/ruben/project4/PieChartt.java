package com.example.ruben.project4;

import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;


public class PieChartt extends AbstractPieChartActivity {
    PieChart grafiek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piechartt);

        grafiek = (PieChart) findViewById(R.id.piechart);

        StolenBikesM4 stolenBikes = ((RotterdamBikesApplication) getApplication()).getStolenBikesM4Data(this);
        LabelsAndEntries labelsAndEntries = createPieData(stolenBikes.getGroupedByBrand(), stolenBikes.getTotal());

        PieDataSet dataset = new PieDataSet(labelsAndEntries.entries, "");
        PieData data = new PieData(labelsAndEntries.labels, dataset);
        Legend legend = grafiek.getLegend();
        grafiek.setData(data);
        grafiek.setHoleRadius(50f);
        grafiek.setTransparentCircleRadius(0f);
        grafiek.animateY(1000);
        dataset.setValueTextSize(12f);
        dataset.setColors(ColorTemplate.PASTEL_COLORS);
        grafiek.setDescription("");
        grafiek.setCenterText("%");
        grafiek.setCenterTextSizePixels(200f);
        dataset.setColors(new int[] {
                        R.color.pie_1_6, R.color.pie_1_1, R.color.pie_1_2,
                        R.color.pie_1_5, R.color.pie_1_4, R.color.pie_1_3},
                this);
        legend.setWordWrapEnabled(true);
    }
}
