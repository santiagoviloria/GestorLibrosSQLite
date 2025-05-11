package com.example.gestorlibrossqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    private static final String DB_NAME = "LibrosDB";
    private static final int DB_VERSION = 1;

    public BaseDatos(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE libro(" +
                "codigo TEXT PRIMARY KEY," +
                "nombre TEXT," +
                "autor TEXT," +
                "editorial TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS libro");
        onCreate(db);
    }
}
