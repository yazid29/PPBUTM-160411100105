package com.example.cobaimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView register;
    EditText edUsrname,passw;
    Button butt_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setHomeButtonEnabled(true);

        register = findViewById(R.id.register);
        edUsrname = findViewById(R.id.edUsrname);
        passw = findViewById(R.id.passw);
        butt_log = findViewById(R.id.butt_log);

//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        butt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edUsrname.getText().toString().equals("0") && passw.getText().toString().equals("0")){
                    Toast.makeText(getApplicationContext(),"Cie Login ...",Toast.LENGTH_SHORT).show();
                    openActivityLogin();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Something wrong with your brain ...",Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRegister();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_awal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                Toast.makeText(getApplicationContext(), "Username : 0 ...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu2:
                Toast.makeText(getApplicationContext(), "Password : 0 ...", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void openActivityLogin(){
        Intent intentLog = new Intent(this, MainActivityAgenda.class);
        startActivity(intentLog);
    }

    public void openActivityRegister(){
        Intent intentReg = new Intent(this, Register.class);
        startActivity(intentReg);
    }
}
