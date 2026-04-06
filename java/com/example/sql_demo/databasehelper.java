package com.example.sql_demo;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class databasehelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyDB.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "data_table";
    private static final String COL_ID = "id";
    private static final String COL_TEXT = "text_value";

    Context context;

    public databasehelper(Context context) 
	{
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_TEXT + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert data method
    public void insertData(String text) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_TEXT, text);

        long result = db.insert(TABLE_NAME, null, values);

        if (result == -1) {
            Toast.makeText(context, "Data not inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data inserted successfully", Toast.LENGTH_SHORT).show();
        }
    }
}

