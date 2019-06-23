package com.example.cobaimage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_db_db.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table tbl_iuran(no integer primary key, nama_org text null, bayar_bln text null, status_bayar text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO tbl_iuran (no, nama_org, bayar_bln, status_bayar) VALUES ('1', 'Haikal', '15000', 'Sudah');";
        db.execSQL(sql);
        sql = "INSERT INTO tbl_iuran (no, nama_org, bayar_bln, status_bayar) VALUES ('2', 'Rachmad', '15000', 'Sudah');";
        db.execSQL(sql);
        sql = "INSERT INTO tbl_iuran (no, nama_org, bayar_bln, status_bayar) VALUES ('3', 'Yazid', '15000', 'Sudah');";
        db.execSQL(sql);
        sql = "INSERT INTO tbl_iuran (no, nama_org, bayar_bln, status_bayar) VALUES ('4', 'Brian', '15000', 'Sudah');";
        db.execSQL(sql);
        sql = "INSERT INTO tbl_iuran (no, nama_org, bayar_bln, status_bayar) VALUES ('5', 'Yusuf', '15000', 'Sudah');";
        db.execSQL(sql);
        sql = "INSERT INTO tbl_iuran (no, nama_org, bayar_bln, status_bayar) VALUES ('6', 'Aan', '15000', 'Sudah');";
        db.execSQL(sql);
        sql = "INSERT INTO tbl_iuran (no, nama_org, bayar_bln, status_bayar) VALUES ('7', 'Ade', '15000', 'Sudah');";
        db.execSQL(sql);

        String sql2 = "create table tbl_iuran_air(no integer primary key, nama_org text null, bayar_bln text null, status_bayar text null);";
        Log.d("Data", "onCreate: " + sql2);
        db.execSQL(sql2);
        sql2 = "INSERT INTO tbl_iuran_air (no, nama_org, bayar_bln, status_bayar) VALUES ('1', 'Haikal', '15000', 'Belum');";
        db.execSQL(sql2);
        sql2 = "INSERT INTO tbl_iuran_air (no, nama_org, bayar_bln, status_bayar) VALUES ('2', 'Rachmad', '15000', 'Belum');";
        db.execSQL(sql2);
        sql2 = "INSERT INTO tbl_iuran_air (no, nama_org, bayar_bln, status_bayar) VALUES ('3', 'Yazid', '15000', 'Belum');";
        db.execSQL(sql2);
        sql2 = "INSERT INTO tbl_iuran_air (no, nama_org, bayar_bln, status_bayar) VALUES ('4', 'Brian', '15000', 'Belum');";
        db.execSQL(sql2);
        sql2 = "INSERT INTO tbl_iuran_air (no, nama_org, bayar_bln, status_bayar) VALUES ('5', 'Yusuf', '15000', 'Belum');";
        db.execSQL(sql2);
        sql2 = "INSERT INTO tbl_iuran_air (no, nama_org, bayar_bln, status_bayar) VALUES ('6', 'Aan', '15000', 'Belum');";
        db.execSQL(sql2);
        sql2 = "INSERT INTO tbl_iuran_air (no, nama_org, bayar_bln, status_bayar) VALUES ('7', 'Ade', '15000', 'Belum');";
        db.execSQL(sql2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

}