package com.example.ruben.project4;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import static android.Manifest.permission.WRITE_CALENDAR;

public class NoteMain extends AppCompatActivity {
    private static final int HALF_HOUR_IN_MILLIS = 1000 * 60 * 30;
    private static final int REQUEST_CODE_CREATE_EVENT = 1;

    private List<String> eventIds;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;
    private Button addEventButton;

    TimePickerDialog.OnTimeSetListener onTimeSetListener;

    TextView textAlarmPrompt;
    TextView newEventTitle;
    TimePickerDialog timePickerDialog;
    final static int RQS_1 = 1;

    Calendar selectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notemain);

        onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                setSelectedTime(hourOfDay, minute);
            }
        };

        Button setEventTimeButton = (Button) findViewById(R.id.setEventTime);
        setEventTimeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openTimePickerDialog(false);
            }
        });

        addEventButton = (Button) findViewById(R.id.btnAddItem);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewEvent();
            }
        });

        lvItems = (ListView) findViewById(R.id.lvItems);
        eventIds = readItems();
        itemsAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, eventIds);
        lvItems.setAdapter(itemsAdapter);
        setupListViewListener();
        newEventTitle = (TextView) findViewById(R.id.newEventTitle);
    }

    private void setSelectedTime(int hourOfDay, int minute) {
        selectedTime = Calendar.getInstance();

        int dayIncrement = 0;
        // Check if user selected a time earlier than current time of the day
        if (selectedTime.get(Calendar.HOUR_OF_DAY) > hourOfDay ||
                (selectedTime.get(Calendar.HOUR_OF_DAY) == hourOfDay && selectedTime.get(Calendar.MINUTE) > minute)) {
            // User either selected an earlier hour, or earlier minute of the same hour.
            // In either case, we will set the alarm to next day
            dayIncrement = 1;
        }

        selectedTime.add(Calendar.DAY_OF_YEAR, dayIncrement);
    }

    private void addNewEvent() {
        String eventTitle = newEventTitle.getText().toString();

        long startTimeInMillis = selectedTime.getTimeInMillis();
        long endTimeInMillis = startTimeInMillis + HALF_HOUR_IN_MILLIS;

        // Start action insert intent to open calendar app and allow user to complete adding event
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTimeInMillis)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTimeInMillis)
                .putExtra(Events.TITLE, eventTitle)
                .putExtra(Events.DESCRIPTION, eventTitle);
        startActivity(intent);

//        if(canAddEvent()) {
//            ContentResolver cr = getContentResolver();
//            ContentValues values = new ContentValues();
//            values.put(Events.DTSTART, startTimeInMillis);
//            values.put(Events.DTEND, endTimeInMillis);
//            values.put(Events.EVENT_TIMEZONE, TimeZone.getDefault().getID());
//            values.put(Events.TITLE, eventTitle);
//            values.put(Events.DESCRIPTION, eventTitle);
//            values.put(Events.CALENDAR_ID, 3);
//            Uri uri = cr.insert(Events.CONTENT_URI, values);
//
//            // Retrieve ID for new event
//            String eventID = uri.getLastPathSegment();
//            eventIds.add(eventID);
//            writeItems();
//
//
//            newEventTitle.setText("");
//        }

    }
//
//    private boolean canAddEvent() {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
//            return true;
//        }
//        if (checkSelfPermission(WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
//            return true;
//        }
//        if (shouldShowRequestPermissionRationale(WRITE_CALENDAR)) {
//            Toast.makeText(NoteMain.this, "Application needs access to create event!", Toast.LENGTH_LONG)
//                    .show();
//        } else {
//            requestPermissions(new String[]{WRITE_CALENDAR}, REQUEST_CODE_CREATE_EVENT);
//        }
//        return false;
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        if (requestCode == REQUEST_CODE_CREATE_EVENT) {
//            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                addNewEvent();
//            }
//        }
//    }

    private void openTimePickerDialog(boolean is24r) {
        Calendar calendar = Calendar.getInstance();
        timePickerDialog = new TimePickerDialog(NoteMain.this,
                onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), is24r);
        timePickerDialog.setTitle("Set Alarm Time");
        timePickerDialog.show();
    }

    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        eventIds.remove(pos);
                        itemsAdapter.notifyDataSetChanged();
                        writeItems();
                        return true;
                    }

                });
    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.newEventTitle);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
        writeItems();
    }

    private List<String> readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            return new ArrayList<>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, eventIds);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setAlarm(Calendar targetCal) {
        textAlarmPrompt.setText("\n\n***\n" + "herinnering is gezet "
                + targetCal.getTime() + "\n" + "***\n");

        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
                pendingIntent);
    }
}