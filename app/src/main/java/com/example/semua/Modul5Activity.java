package com.example.semua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Modul5Activity extends AppCompatActivity {
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modul4);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }
    public void login(View view) {
        String Uname = "yazid";
        String Upass = "105";
        String name = username.getText().toString();
        String pass = password.getText().toString();

        Intent i = new Intent(this,Modul5_menuActivity.class);
        if(name.length()>0){
            if (name.matches(Uname)&&(pass.matches(Upass))){
                startActivity(i);
                finish();
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
