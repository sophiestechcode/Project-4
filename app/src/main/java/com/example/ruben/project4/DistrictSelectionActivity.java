package com.example.ruben.project4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Ruben on 28-6-2016.
 */
public class DistrictSelectionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;

    static final String[] SPINNER_TEXTS;
    static {
        // Construct the district names to show using enum values
        RotterdamDistricts[] districts = RotterdamDistricts.values();
        SPINNER_TEXTS = new String[districts.length + 1];
        // First value will be displayed by default
        SPINNER_TEXTS[0] = "SELECT A DISTRICT";
        for (int i = 0; i < districts.length; i++) {
            SPINNER_TEXTS[i+1] = districts[i].name();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = (Spinner)findViewById(R.id.dynamic_spinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(DistrictSelectionActivity.this,
                android.R.layout.simple_spinner_item, SPINNER_TEXTS);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        // First item is "Select a district" so we skip it
        if (position == 0) {
            return;
        }

        // Find which district is selected
        RotterdamDistricts selectedDistrict = RotterdamDistricts.values()[position - 1];
        // Create intent to switch to target activity
        Intent intent = new Intent(DistrictSelectionActivity.this, TheftAndStoragePerDistrict.class);
        // Pass the selectedDistrict information to target activity using intent
        intent.putExtra("selectedDistrict", selectedDistrict);
        // Switch to target activity
        startActivity(intent);
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }
}
