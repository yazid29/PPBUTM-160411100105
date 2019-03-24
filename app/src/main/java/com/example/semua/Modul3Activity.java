package com.example.semua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Modul3Activity extends AppCompatActivity {
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modul3);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        Log.d("Modul3Activity","onCreate");
    }

    public void login(View view) {
        String Uname = "user";
        String Upass = "pass";
        String name = username.getText().toString();
        String pass = password.getText().toString();

        Intent i = new Intent(this,Modul2Activity.class);
        if(name.length()>0){
            if (name.matches(Uname)&&(pass.matches(Upass))){
                startActivity(i);
                onStop();
                Log.d("Modul3Activity","onStop");
                finish();
                Log.d("Modul3Activity","finish");
            }else {
                Toast t = Toast.makeText(getApplicationContext(),"Username atau Password Salah",Toast.LENGTH_SHORT);
                t.show();
            }
        }else{
            if (name.isEmpty()){
                Toast t = Toast.makeText(getApplicationContext(),"Username Kosong",Toast.LENGTH_SHORT);
                t.show();
            }else if (pass.isEmpty()){
                Toast t = Toast.makeText(getApplicationContext(),"Password Kosong",Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }
}
