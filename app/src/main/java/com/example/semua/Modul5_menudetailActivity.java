package com.example.semua;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Modul5_menudetailActivity extends AppCompatActivity {
    public ArrayList<coffee> dataCoffee;
    TextView namamenutxt,hargamenutxt;
    EditText jumlahmenuMu;
    Button minusMenu,plusMenu,btnAddtoCart;
    Integer no;
    protected Cursor cursor;
    DataHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modul5_menudetail);

        dbHelper = new DataHelper(this);
        namamenutxt = findViewById(R.id.namamenutxt);
        hargamenutxt = findViewById(R.id.hargamenutxt);
        jumlahmenuMu = findViewById(R.id.jumlahmenuMu);
        minusMenu = findViewById(R.id.minusMenu);
        plusMenu = findViewById(R.id.plusMenu);
        btnAddtoCart = findViewById(R.id.btnAddtoCart);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM COFFEE WHERE namamenu = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            cursor.moveToPosition(0);
            no=cursor.getInt(0);
            namamenutxt.setText(cursor.getString(1).toString());
            hargamenutxt.setText(cursor.getString(2).toString());
            jumlahmenuMu.setText(cursor.getString(3).toString());
        }
    }

    public void plus(View view){
        String j = jumlahmenuMu.getText().toString();
        if (j.isEmpty()){
            j="0";
            Integer jmlh = Integer.valueOf(j);
            Integer total = jmlh+1;
            jumlahmenuMu.setText(total.toString());
        }else {
            Integer jmlh = Integer.valueOf(j);
            Integer total = jmlh+1;
            jumlahmenuMu.setText(total.toString());
        }
    }
    public void minus(View view){
        String j = jumlahmenuMu.getText().toString();
        if (j.isEmpty()) {
            j = "0";
        }
        else {
            Integer jmlh = Integer.valueOf(j);
            if (jmlh > 0) {
                Integer total = jmlh - 1;
                jumlahmenuMu.setText(total.toString());
            }
        }
    }

    public void toCart(View view) {
        Integer harga,jumlah,total;

        harga=Integer.valueOf(hargamenutxt.getText().toString());
        jumlah=Integer.valueOf(jumlahmenuMu.getText().toString());

        total = harga * jumlah;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("update COFFEE set namamenu='"+
                namamenutxt.getText().toString() +"', harga='" +
                hargamenutxt.getText().toString()+"', jumlah='"+
                jumlahmenuMu.getText().toString() +"', total='" +
                total + "' where no='" +no+"'");
        //Modul5_menuActivity.ma.RefreshList();
        finish();
    }
}