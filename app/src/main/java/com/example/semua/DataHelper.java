package com.example.semua;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private SQLiteDatabase mWritableDB;
    private SQLiteDatabase mReadableDB;
    private static final String DATABASE_NAME = "coffeelist.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table COFFEE(nomor integer primary key, namamenu text null, harga text null, jumlah text null, total integer null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO COFFEE (nomor, namamenu, harga, jumlah, total) " +
                "VALUES ('1','Arabika','7000','0','0')," +
                "('2','Robusta','8000','0','0')," +
                "('3','Americana','9000','0','0');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }
}