package com.example.ruben.project4;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ruben.project4.data.FietsDiefstal;
import com.example.ruben.project4.data.FietsTrommel;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elif on 4-7-2016.
 */
public class CsvReader {
    private final AppCompatActivity activity;

    public CsvReader(AppCompatActivity activity) {
        this.activity = activity;
    }

    public List<FietsTrommel> readFietsTrommels() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        List<FietsTrommel> fietsTrommels = new ArrayList<>();

        InputStream inputStream = activity.getResources().openRawResource(R.raw.fietstrommels);
        // Sample code from apache commons for iteration
        Reader in = new InputStreamReader(inputStream);
        try {
            int index = 0;
            // Use iterator pattern to convert each record to FietsTrommel objects
            for (CSVRecord record : CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreEmptyLines().withDelimiter(';').parse(in)) {
                fietsTrommels.add(
                        new FietsTrommel(
                                record.get(1),
                                record.get(2),
                                record.get(3),
                                Double.valueOf(record.get(4).replace(',','.')),
                                Double.valueOf(record.get(5).replace(',','.')),
                                record.get(6),
                                dateFormat.parse(record.get(7))
                        )
                );
            }
        } catch (IOException | ParseException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return fietsTrommels;
    }

    public List<FietsDiefstal> readFietsDiefstal() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        List<FietsDiefstal> fietsDiefstals = new ArrayList<>();

        InputStream inputStream = activity.getResources().openRawResource(R.raw.fietsdiefstal);
        // Sample code from apache commons for iteration
        Reader in = new InputStreamReader(inputStream);
        try {
            // Use iterator pattern to convert each record to FietsTrommel objects
            for (CSVRecord record : CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreEmptyLines().parse(in)) {
                fietsDiefstals.add(
                        new FietsDiefstal(
                                record.get(2),
                                record.get(7),
                                record.get(5),
                                dateFormat.parse(record.get(1)),
                                record.get(22),
                                record.get(24)
                        )
                );
            }
        } catch (IOException | ParseException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return fietsDiefstals;
    }

    public List<M1> readM1s() {
        InputStream ins = activity.getResources().openRawResource(R.raw.m1);
        BufferedReader reader = new BufferedReader(new InputStreamReader(ins, Charset.defaultCharset()));
        List<M1> m1List = new ArrayList<>();
        try {
            // Skip header line
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < 2) {
                    Log.w("Invalid Record!", "One of the records in m1.csv had invalid format. Skipping the line with value: " + line);
                    continue;
                }
                M1 m1 = new M1(columns[0].trim(), columns[1].trim());
                m1List.add(m1);
            }
        } catch (IOException e) {
            Log.e("Exception!",
                    "Could not read m1.csv, returning empty list. Exception details attached.",
                    e);
        }
        return m1List;
    }

    public List<M2> readM2s() {
        InputStream ins = activity.getResources().openRawResource(R.raw.m2);
        BufferedReader reader = new BufferedReader(new InputStreamReader(ins, Charset.defaultCharset()));
        List<M2> m2List = new ArrayList<>();
        try {
            // Skip header line
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < 2) {
                    Log.w("Invalid Record!", "One of the records in m2.csv had invalid format. Skipping the line with value: " + line);
                    continue;
                }
                M2 m2 = new M2(columns[0].trim(), Integer.valueOf(columns[1].trim()));
                m2List.add(m2);
            }
        } catch (IOException e) {
            Log.e("Exception!",
                    "Could not read m1.csv, returning empty list. Exception details attached.",
                    e);
        }
        return m2List;
    }

    public List<M3> readM3s() {
        InputStream ins = activity.getResources().openRawResource(R.raw.m3);
        BufferedReader reader = new BufferedReader(new InputStreamReader(ins, Charset.defaultCharset()));
        List<M3> m3List = new ArrayList<>();
        try {
            // Skip header line
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < 4) {
                    Log.w("Invalid Record!", "One of the records in m3.csv had invalid format. Skipping the line with value: " + line);
                    continue;
                }
                M3 m3 = new M3(
                        Integer.valueOf(columns[0].trim()),
                        columns[1].trim(),
                        Integer.valueOf(columns[2].trim()),
                        Integer.valueOf(columns[3].trim()));
                m3List.add(m3);
            }
        } catch (IOException e) {
            Log.e("Exception!",
                    "Could not read m1.csv, returning empty list. Exception details attached.",
                    e);
        }
        return m3List;
    }

    public List<M4> readM4s() {
        InputStream ins = activity.getResources().openRawResource(R.raw.m4);
        BufferedReader reader = new BufferedReader(new InputStreamReader(ins, Charset.defaultCharset()));
        List<M4> m4List = new ArrayList<>();
        try {
            // Skip header line
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < 3) {
//                    Log.w("Invalid Record!", "One of the records in m4.csv had invalid format. Skipping the line with value: " + line);
                    continue;
                }
                M4 m4 = new M4(columns[0].trim(), columns[1].trim(), columns[2].trim());
                m4List.add(m4);
            }
        } catch (IOException e) {
            Log.e("Exception!",
                    "Could not read m1.csv, returning empty list. Exception details attached.",
                    e);
        }
        return m4List;
    }
}
