package com.eric.quiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    static final String TITLE = "title";
    static final String VALUE = "value";
    private static final String DATABASE_NAME = "db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE results (_id INTEGER PRIMARY KEY, name TEXT, question_1 TEXT, question_2 TEXT, question_3 TEXT, question_4 TEXT, question_5 TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
