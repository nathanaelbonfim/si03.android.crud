package com.si03.android.bim3.crud.libs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "CrudDatabase";
    private static final int DATABASE_VERSION = 1;

    public Database(Context applicationContext) {
        super(applicationContext, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Migrations.initial());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor query(String sql) {
        SQLiteDatabase db = getReadableDatabase();

        return db.rawQuery(sql, null);
    }
}
