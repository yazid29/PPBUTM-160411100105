package com.example.semua;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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

import java.util.ArrayList;

public class Modul4_menuActivity extends AppCompatActivity {
    private RecyclerView rvmenu;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public ArrayList<coffee> coffeeList;
    TextView namapemesan,jumlahtxt;
    EditText inputNama;
    RadioGroup radiogroupbhs;
    RadioButton BhsID,BhsEN;
    Button pilihBhs,order;
    String bhs="ID";

    void addData(){
        coffeeList = new ArrayList<>();
        coffeeList.add(new coffee(0,"Arabica","7000","0",0));
        coffeeList.add(new coffee(1,"Robusta","8000","0",0));
        coffeeList.add(new coffee(2,"Americana","9000","0",0));
    }
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
        rvmenu = findViewById(R.id.rvmenu);
        jumlahtxt = findViewById(R.id.jumlahtxt);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addData();
        rvmenu.setHasFixedSize(true);

        mAdapter = new Modul4_RecycleViewAdapter(this,coffeeList);
        rvmenu.setAdapter(mAdapter);

        layoutManager = new LinearLayoutManager(this);
        rvmenu.setLayoutManager(layoutManager);
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
        String rdbhs= bhs;
        String namamu = inputNama.getText().toString();
        Integer arabica = coffeeList.get(0).getTotal();
        Integer robusta = coffeeList.get(1).getTotal();
        Integer americana = coffeeList.get(2).getTotal();

        Integer hasil = arabica+robusta+americana;
        Intent i = new Intent(this,Modul4_pembayaranActivity.class);
        if (!namamu.isEmpty()){
            if(namamu.matches("^[a-zA-Z]*$")) {
                if (arabica != 0 || robusta != 0 || americana != 0) {
                    i.putExtra("bhs", rdbhs);
                    i.putExtra("name", namamu);
                    i.putExtra("msgJumlah", hasil);
                    startActivity(i);
                } else {
                    Toast.makeText(this, "Silahkan PilihMenu", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this,"Hanya Menerima Huruf",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Nama Kosong",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Integer index = data.getIntExtra("index",0);
                Integer jumlahmenu = data.getIntExtra("jumlahmenu",0);
                Integer total = data.getIntExtra("totalHarga",0);

                coffeeList.get(index).setJumlah(jumlahmenu.toString());
                coffeeList.get(index).setTotal(total);
                mAdapter.notifyDataSetChanged();
            }
        }
    }
}

