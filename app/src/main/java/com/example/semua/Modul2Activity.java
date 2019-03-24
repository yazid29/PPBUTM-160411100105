package com.example.semua;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Modul2Activity extends AppCompatActivity {
    TextView namapemesan,menu,sajian,coba;
    EditText inputNama,jumlah;
    RadioGroup radiogroupbhs,rdsajian;
    RadioButton BhsID,BhsEN,hangat,dingin;
    Button pilihBhs,order,plus,minus,hubungi;
    CheckBox arabica,robusta,american;
    Integer jumlahPesanan,a,b,c,total;
    String bhs="ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modul2);

        pilihBhs = findViewById(R.id.pilihBhs);
        radiogroupbhs = findViewById(R.id.radiogroupbhs);
        BhsEN = findViewById(R.id.BhsEN);
        BhsID = findViewById(R.id.BhsID);
        namapemesan = findViewById(R.id.namapemesan);
        inputNama = findViewById(R.id.inputNama);
        order = findViewById(R.id.order);
        menu = findViewById(R.id.menu);
        sajian = findViewById(R.id.sajian);
        hangat = findViewById(R.id.hangat);
        dingin = findViewById(R.id.dingin);
        jumlah = findViewById(R.id.jumlah);
        rdsajian = findViewById(R.id.rdsajian);
        arabica = findViewById(R.id.arabica);
        robusta = findViewById(R.id.robusta);
        american = findViewById(R.id.american);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        hubungi = findViewById(R.id.hubungi);
    }
    public void pilihRD(View view){
        int selectedId = radiogroupbhs.getCheckedRadioButtonId();
        if (selectedId==BhsEN.getId()){
            pilihBhs.setText(getString(R.string.ENbtnpilih));
            namapemesan.setText(getString(R.string.ENpemesan));
            inputNama.setHint(getString(R.string.ENinputNama));
            order.setText(getString(R.string.ENpesan));
            menu.setText(getString(R.string.ENmenu));
            sajian.setText(getString(R.string.ENsajian));
            hangat.setText(getString(R.string.ENhangat));
            dingin.setText(getString(R.string.ENdingin));
            bhs="EN";
        }else if(selectedId==BhsID.getId()){
            pilihBhs.setText(getString(R.string.IDbtnpilih));
            namapemesan.setText(getString(R.string.IDpemesan));
            inputNama.setHint(getString(R.string.IDinputNama));
            order.setText(getString(R.string.IDpesan));
            menu.setText(getString(R.string.IDmenu));
            sajian.setText(getString(R.string.IDsajian));
            hangat.setText(getString(R.string.IDhangat));
            dingin.setText(getString(R.string.IDdingin));
            bhs="ID";
        }
    }

    public void plus(View view){
        Integer jmlh = Integer.valueOf(jumlah.getText().toString());
        Integer total = jmlh+1;
        jumlah.setText(total.toString());
    }
    public void minus(View view){
        Integer jmlh = Integer.valueOf(jumlah.getText().toString());
        if (jmlh>0){
            Integer total = jmlh-1;
            jumlah.setText(total.toString());
        }
    }

    public  void order(View view){
        Integer menuhangat=500,menudingin=1000,
                menuarabica=7000,menurobusta=8000,
                menuamerican=9000;
        String rdbhs= bhs;
        Boolean pesanHangat,pesanDingin,menuCoffe;
        String n,name = inputNama.getText().toString();

        int selectedId = rdsajian.getCheckedRadioButtonId();
        pesanHangat = selectedId==hangat.getId();
        pesanDingin = selectedId==dingin.getId();
        menuCoffe = arabica.isChecked()||robusta.isChecked()||american.isChecked();
        n = jumlah.getText().toString();
        if (n.matches("")){
            jumlahPesanan = 0;
        }else{
            jumlahPesanan = Integer.valueOf(jumlah.getText().toString());
        }
        Intent i = new Intent(this,Modul22Activity.class);
        if(jumlahPesanan>0&&(pesanHangat||pesanDingin)&&menuCoffe &&(inputNama.length()>0)){
            String hasil;
            a=0;b=0;c=0;
            if(pesanHangat&&menuCoffe){
                if(arabica.isChecked()){
                    a=(menuarabica+menuhangat)*jumlahPesanan;
                    if(robusta.isChecked()){
                        b=(menurobusta+menuhangat)*jumlahPesanan;
                        if (american.isChecked()){
                            c=(menuamerican+menuhangat)*jumlahPesanan;
                        }
                    }else if(american.isChecked()){
                        c=(menuamerican+menuhangat)*jumlahPesanan;
                    }
                }
                else if (robusta.isChecked()){
                    b=(menurobusta+menuhangat)*jumlahPesanan;
                    if(arabica.isChecked()){
                        a=(menuarabica+menuhangat)*jumlahPesanan;
                        if (american.isChecked()){
                            c=(menuamerican+menuhangat)*jumlahPesanan;
                        }
                    }else if(american.isChecked()){
                        c=(menuamerican+menuhangat)*jumlahPesanan;
                    }
                }
                else if (american.isChecked()){
                    c=(menuamerican+menuhangat)*jumlahPesanan;
                    if(arabica.isChecked()){
                        a=(menuarabica+menuhangat)*jumlahPesanan;
                        if (robusta.isChecked()){
                            b=(menurobusta+menuhangat)*jumlahPesanan;
                        }
                    }else if(robusta.isChecked()){
                        b=(menurobusta+menuhangat)*jumlahPesanan;
                    }
                }
                total=a+b+c;
            }
            else if(pesanDingin&&menuCoffe){
                if(arabica.isChecked()){
                    a=(menuarabica+menudingin)*jumlahPesanan;
                    if(robusta.isChecked()){
                        b=(menurobusta+menudingin)*jumlahPesanan;
                        if (american.isChecked()){
                            c=(menuamerican+menudingin)*jumlahPesanan;
                        }
                    }else if(american.isChecked()){
                        c=(menuamerican+menudingin)*jumlahPesanan;
                    }
                }
                else if (robusta.isChecked()){
                    b=(menurobusta+menudingin)*jumlahPesanan;
                    if(arabica.isChecked()){
                        a=(menuarabica+menudingin)*jumlahPesanan;
                        if (american.isChecked()){
                            c=(menuamerican+menudingin)*jumlahPesanan;
                        }
                    }else if(american.isChecked()){
                        c=(menuamerican+menudingin)*jumlahPesanan;
                    }
                }
                else if (american.isChecked()){
                    c=(menuamerican+menudingin)*jumlahPesanan;
                    if(arabica.isChecked()){
                        a=(menuarabica+menudingin)*jumlahPesanan;
                        if (robusta.isChecked()){
                            b=(menurobusta+menudingin)*jumlahPesanan;
                        }
                    }else if(robusta.isChecked()){
                        b=(menurobusta+menudingin)*jumlahPesanan;
                    }
                }
                total=a+b+c;
            }
            hasil=total.toString();
            i.putExtra("bhs",rdbhs);
            i.putExtra("name",name);
            i.putExtra("msgJumlah",hasil);
            startActivity(i);
        }
    }

    public void hubungi(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:*888#"));
        if (ActivityCompat.checkSelfPermission(Modul2Activity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);

    }
}
