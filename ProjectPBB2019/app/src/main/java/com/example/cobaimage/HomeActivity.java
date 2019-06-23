package com.example.cobaimage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {

    String[] list;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbCenter;
    public static HomeActivity home1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btn=findViewById(R.id.butt_add);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent inte = new Intent(HomeActivity.this, buat_data.class);
                startActivity(inte);
            }
        });

        home1 = this;
        dbCenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = dbCenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tbl_iuran", null);
        list = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            list[cc] = cursor.getString(1);
        }
//
        ListView01 = findViewById(R.id.listView1);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, list));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = list[arg2];
                final CharSequence[] dialogitem = {"Lihat", "Edit", "Hapus"};
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                builder.setTitle("Erabe ..");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getApplicationContext(), lihat_data.class);
                                i.putExtra("nama_org", selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent ii = new Intent(getApplicationContext(), update_data.class);
                                ii.putExtra("nama_org", selection);
                                startActivity(ii);
                                break;
                            case 2:
                                SQLiteDatabase db = dbCenter.getWritableDatabase();
                                db.execSQL("delete from tbl_iuran where nama_org ='" + selection + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}
