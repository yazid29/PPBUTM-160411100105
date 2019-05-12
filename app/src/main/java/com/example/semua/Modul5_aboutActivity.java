package com.example.semua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Modul5_aboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modul5_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
