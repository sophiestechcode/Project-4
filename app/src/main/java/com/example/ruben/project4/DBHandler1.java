package com.example.ruben.project4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elif on 4-7-2016.
 */
public class DBHandler1 extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "M1";
    // Contacts table name
    private static final String TABLE_M1 = "M1";
    // M1 Table Columns names


    private static final String KEY_OMSCHRIJVING = "omschrijving";
    private static final String KEY_DEELGEMEENTE = "deelgemeente";

    public DBHandler1(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_M1 + "("
                + KEY_OMSCHRIJVING + " TEXT," + KEY_DEELGEMEENTE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_M1);
        // Creating tables again
        onCreate(db);
    }

    // Getting All M1
    public List<M1> getAllM1() {
        List<M1> m1List = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_M1;

        Cursor cursor = null;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            cursor = db.rawQuery(selectQuery, null);
            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    M1 m1 = new M1(cursor.getString(0), cursor.getString(1));
                    // Adding contact to list
                    m1List.add(m1);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        // return contact list
        return m1List;
    }

    // Count M1
    public int getM1Count() {
        String countQuery = "SELECT * FROM " + TABLE_M1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        int count = -1;
        try {
            cursor = db.rawQuery(countQuery, null);
            count = cursor.getCount();
            cursor.close();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        // return count
        return count;
    }
}
