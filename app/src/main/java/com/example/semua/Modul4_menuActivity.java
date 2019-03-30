package com.example.semua;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Modul4_menuActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    TextView namapemesan;
    EditText inputNama;
    RadioGroup radiogroupbhs;
    RadioButton BhsID,BhsEN;
    Button pilihBhs,order;
    String bhs="ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modul4_menu);

        pilihBhs = findViewById(R.id.pilihBhs);
        radiogroupbhs = findViewById(R.id.radiogroupbhs);
        BhsEN = findViewById(R.id.BhsEN);
        BhsID = findViewById(R.id.BhsID);
        namapemesan = findViewById(R.id.namapemesan);
        inputNama = findViewById(R.id.inputNama);
        order = findViewById(R.id.order);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void pilihRD(View view){
        int selectedId = radiogroupbhs.getCheckedRadioButtonId();
        if (selectedId==BhsEN.getId()){
            pilihBhs.setText(getString(R.string.ENbtnpilih));
            namapemesan.setText(getString(R.string.ENpemesan));
            inputNama.setHint(getString(R.string.ENinputNama));
            order.setText(getString(R.string.ENpesan));
            bhs="EN";
        }else if(selectedId==BhsID.getId()){
            pilihBhs.setText(getString(R.string.IDbtnpilih));
            namapemesan.setText(getString(R.string.IDpemesan));
            inputNama.setHint(getString(R.string.IDinputNama));
            order.setText(getString(R.string.IDpesan));
            bhs="ID";
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.logout:
                Intent i = new Intent(this,Modul4Activity.class);
                startActivity(i);
                finish();
                return true;
            case R.id.about:
                Intent j = new Intent(this,Modul4_aboutActivity.class);
                startActivity(j);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void order(View view) {
        Intent i = new Intent(this,Modul4_pembayaranActivity.class);
        startActivity(i);
    }
}

