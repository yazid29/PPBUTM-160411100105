package com.example.semua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView hello,statusBMI;
    EditText siapa,tb,bb;
    Button btnmu,btnBMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //List Modul
    public void listModulku(View view){
        setContentView(R.layout.listmodul);
    }

    public void Modul1(View view){
        setContentView(R.layout.modul1);
        siapa = findViewById(R.id.siapa);
        btnmu = findViewById(R.id.btnmu);
        hello = findViewById(R.id.hello);

        tb= findViewById(R.id.tb);
        bb= findViewById(R.id.bb);
        btnBMI = findViewById(R.id.btnBMI);
        statusBMI=findViewById(R.id.statusBMI);
    }

    public void Modul2(View view){
        Intent i = new Intent(this,Modul2Activity.class);
        startActivity(i);
    }

    public void Modul3(View view){
        Intent i = new Intent(this,Modul3Activity.class);
        startActivity(i);
    }

    public void Modul4(View view){
        Intent i = new Intent(this,Modul4Activity.class);
        startActivity(i);
    }
    public void Modul5(View view){
        Intent i = new Intent(this,Modul5Activity.class);
        startActivity(i);
    }

    //Modul1
    //no1
    public void klikbutton(View view){
        String nama=siapa.getText().toString();
        hello.setText("Hallo "+nama);
    }
    //no2
    public void klikbutton2(View view){
        String status;
        Double a = Double.valueOf(bb.getText().toString());
        Double b = Double.valueOf(tb.getText().toString());
        Double hasil;
        hasil=a/((b/100)*(b/100));
        if (hasil<18.5){
            status="Underweight";
        }else if (hasil>=18.5 && hasil<=24.9){
            status="Normal weight";
        }else if(hasil>=25 && hasil<=29.9){
            status="Over weight";
        }else if(hasil>=30 && hasil<=34.9){
            status="Obesity 1";
        }else if(hasil>=35 && hasil<=39.9){
            status="Obesity 2";
        }else {
            status="Obesity 3";
        }
        String n=hasil.toString();
        statusBMI.setText(status+"\n"+n);
    }


    public void btnkembali(View view) {
        setContentView(R.layout.listmodul);
    }
    public void btnhome(View view){
        setContentView(R.layout.activity_main);
    }
}
