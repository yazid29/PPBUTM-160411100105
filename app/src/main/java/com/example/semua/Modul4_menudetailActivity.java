package com.example.semua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Modul4_menudetailActivity extends AppCompatActivity {
    public ArrayList<coffee> dataCoffee;
    TextView namamenutxt,hargamenutxt;
    EditText jumlahmenuMu;
    Button minusMenu,plusMenu,btnAddtoCart;
    String namamenu,hargamenu,jumlahmenu;
    Integer index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modul4_menudetail);
        namamenutxt = findViewById(R.id.namamenutxt);
        hargamenutxt = findViewById(R.id.hargamenutxt);
        jumlahmenuMu = findViewById(R.id.jumlahmenuMu);
        minusMenu = findViewById(R.id.minusMenu);
        plusMenu = findViewById(R.id.plusMenu);
        btnAddtoCart = findViewById(R.id.btnAddtoCart);

        Intent intent = getIntent();
        namamenu = intent.getStringExtra("namamenu");
        hargamenu = intent.getStringExtra("hargamenu");
        jumlahmenu = intent.getStringExtra("jumlahmenu");
        index = intent.getIntExtra("index",0);

        namamenutxt.setText(namamenu);
        hargamenutxt.setText(hargamenu);
        jumlahmenuMu.setText(jumlahmenu);
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

        Intent j = new Intent(this,Modul4_menuActivity.class);
        j.putExtra("index",index);
        j.putExtra("jumlahmenu",jumlah);
        j.putExtra("totalHarga",total);
        onActivityResult(1,RESULT_OK,j);
        setResult(RESULT_OK,j);
        finish();
    }
}
