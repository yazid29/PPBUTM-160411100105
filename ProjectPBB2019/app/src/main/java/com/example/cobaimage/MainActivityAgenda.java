package com.example.cobaimage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivityAgenda extends AppCompatActivity {

//    String[] list;
//    ListView ListView01;
//    Menu menu;
//    protected Cursor cursor;
//    DataHelper dbCenter;
//    public static MainActivityAgenda ma2;

    Button button_listrik,button_air;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_agenda);
        getSupportActionBar().setHomeButtonEnabled(true);

        button_listrik = findViewById(R.id.button_listrik);
        button_air = findViewById(R.id.button_air);

        button_listrik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityListrik();
            }
        });

        button_air.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAir();
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
                Toast.makeText(getApplicationContext(), "Haikal 109 ...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu2:
                Toast.makeText(getApplicationContext(), "Yazid 105 ...", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openActivityListrik(){
        Intent ActList = new Intent(this, HomeActivity.class);
        startActivity(ActList);
    }

    public void openActivityAir(){
        Intent ActAir = new Intent(this, HomeActivityAir.class);
        startActivity(ActAir);
    }

//        Button btn=findViewById(R.id.butt_addA);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                // TODO Auto-generated method stub
//                Intent inte = new Intent(MainActivityAgenda.this, buat_data.class);
//                startActivity(inte);
//            }
//        });
//
//        ma2 = this;
//        dbCenter = new DataHelper(this);
//        RefreshList();
    }

//    public void RefreshList() {
//        SQLiteDatabase db = dbCenter.getReadableDatabase();
//        cursor = db.rawQuery("SELECT * FROM tbl_agenda", null);
//        list = new String[cursor.getCount()];
//        cursor.moveToFirst();
//
//        for (int cc = 0; cc < cursor.getCount(); cc++) {
//            cursor.moveToPosition(cc);
//            list[cc] = cursor.getString(1).toString();
//        }
////
//        ListView01 = findViewById(R.id.listViewA);
//        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, list));
//        ListView01.setSelected(true);
//        final Intent i = new Intent(this,HomeActivity.class);
//        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
//                final String selection = list[arg2];
//                Toast.makeText(getApplicationContext(),selection,Toast.LENGTH_SHORT).show();
//                //i.putExtra("agenda", selection);
//                //startActivity(i);
//            }
//        });
//        ((ArrayAdapter) ListView01.getAdapter()).notifyDataSetInvalidated();
//    }

