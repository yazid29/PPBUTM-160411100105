package com.example.semua;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
public class Modul5_menuActivity extends AppCompatActivity {
    DataHelper dbcenter;
    public ArrayList<coffee> coffeeList = new ArrayList<coffee>();
    public static Modul5_menuActivity ma;
    protected Cursor cursor,cursor1,cursor2,cursor3;
    TextView namapemesan,jumlahtxt;
    EditText inputNama;
    ListView listView;
    RadioGroup radiogroupbhs;
    RadioButton BhsID,BhsEN;
    Button pilihBhs,order;
    String bhs="ID";
    String[] daftar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modul5_menu);

        pilihBhs = findViewById(R.id.pilihBhs);
        radiogroupbhs = findViewById(R.id.radiogroupbhs);
        BhsEN = findViewById(R.id.BhsEN);
        BhsID = findViewById(R.id.BhsID);
        namapemesan = findViewById(R.id.namapemesan);
        inputNama = findViewById(R.id.inputNama);
        order = findViewById(R.id.order);
        listView = findViewById(R.id.listview);
        jumlahtxt = findViewById(R.id.jumlahtxt);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ma = this;
        dbcenter = new DataHelper(this);
        RefreshList();

    }

    public void RefreshList(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM COFFEE",null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1);
        }
        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        final Intent i = new Intent(this,Modul5_menudetailActivity.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                i.putExtra("nama", selection);
                startActivity(i);
            }
        });
    }

    public void order(View view) {
        String rdbhs= bhs;
        String namamu = inputNama.getText().toString();
        Integer hasil = 0;
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM COFFEE WHERE namamenu = 'Arabika'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            Integer totals = cursor.getInt(4);
            hasil=hasil+totals;
        }
        cursor2 = db.rawQuery("SELECT * FROM COFFEE WHERE namamenu = 'Robusta'",null);
        cursor2.moveToFirst();
        if (cursor2.getCount()>0) {
            Integer totals = cursor2.getInt(4);
            hasil=hasil+totals;
        }
        cursor3 = db.rawQuery("SELECT * FROM COFFEE WHERE namamenu = 'Americana'",null);
        cursor3.moveToFirst();
        if (cursor3.getCount()>0) {
            Integer totals = cursor3.getInt(4);
            hasil=hasil+totals;
        }

        //Toast.makeText(this,hasil.toString(),Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,Modul5_pembayaranActivity.class);
        if (!namamu.isEmpty()){
            if(namamu.matches("^[a-zA-Z]*$")) {
                if (hasil != 0) {
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
                Intent i = new Intent(this,Modul5Activity.class);
                startActivity(i);
                finish();
                return true;
            case R.id.about:
                Intent j = new Intent(this,Modul5_aboutActivity.class);
                startActivity(j);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}