package com.example.cobaimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText RegUsrname,RegPassw,RegCPassw;
    Button butt_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RegUsrname = findViewById(R.id.RegUsrname);
        RegPassw = findViewById(R.id.RegPassw);
        RegCPassw = findViewById(R.id.RegCPassw);
        butt_reg = findViewById(R.id.butt_reg);

        butt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Congrats with ur register ...",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
