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

public class Modul5_pembayaranActivity extends AppCompatActivity {
    TextView detailtxt,ket,masukanUangtxt,hargatotal,namatxt,kembalian,kembaliantxt;
    EditText jumlahUangmu;
    Button btnbayar;
    String rdbhs;
    protected Cursor cursor;
    DataHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modul5_pembayaran);
        hargatotal = findViewById(R.id.hargatotal);
        namatxt = findViewById(R.id.namatxt);
        jumlahUangmu = findViewById(R.id.jumlahUangmu);
        kembaliantxt = findViewById(R.id.kembaliantxt);
        kembalian = findViewById(R.id.kembalian);
        detailtxt=findViewById(R.id.detailtxt);
        ket=findViewById(R.id.ket);
        masukanUangtxt = findViewById(R.id.masukanUangtxt);
        btnbayar = findViewById(R.id.btnbayar);
        String name;
        Integer jumlahPesanan;

        Intent i = getIntent();
        rdbhs = i.getStringExtra("bhs");
        if (rdbhs.matches("EN")){
            detailtxt.setText(getString(R.string.ENrincianPesanan));
            ket.setText(getString(R.string.ENket));
            masukanUangtxt.setText(getString(R.string.ENmasukanUang));
            btnbayar.setText(getString(R.string.ENbayar));
            name = i.getStringExtra("name");
            jumlahPesanan = i.getIntExtra("msgJumlah",0);
            namatxt.setText(name);
            hargatotal.setText(jumlahPesanan.toString());
        }else {
            name = i.getStringExtra("name");
            jumlahPesanan = i.getIntExtra("msgJumlah",0);
            namatxt.setText(name);
            hargatotal.setText(jumlahPesanan.toString());
        }
    }

    public void bayar(View view){
        Integer totalHarga,uangmu,kembalianmu;
        totalHarga = Integer.valueOf(hargatotal.getText().toString());
        uangmu = Integer.valueOf(jumlahUangmu.getText().toString());

        if (uangmu>totalHarga){
            kembalianmu = uangmu - totalHarga;
            if (rdbhs.matches("EN")){
                kembaliantxt.setText(getString(R.string.ENkembalian));
                kembalian.setText(kembalianmu.toString());
            }else{
                kembaliantxt.setText(getString(R.string.IDkembalian));
                kembalian.setText(kembalianmu.toString());
            }


        }else if (uangmu<totalHarga){
            if (rdbhs.matches("EN")){
                kembaliantxt.setText(getString(R.string.ENkurang));
            }else{
                kembaliantxt.setText(getString(R.string.IDkurang));
            }
        }
    }
}
