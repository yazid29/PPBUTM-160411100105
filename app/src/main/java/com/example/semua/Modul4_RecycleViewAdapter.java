package com.example.semua;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class Modul4_RecycleViewAdapter extends RecyclerView.Adapter<Modul4_RecycleViewAdapter.ViewHolder> {
    private ArrayList<coffee> dataCoffee;
    private Context mContext;

    public Modul4_RecycleViewAdapter(Context context,ArrayList<coffee> dataCoffee) {
        mContext = context;
        this.dataCoffee = dataCoffee;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout layoutitem;
        public TextView namamenu,hargamenu,jumlahmenu;

        public ViewHolder(View v) {
            super(v);
            namamenu = v.findViewById(R.id.namamenu);
            hargamenu = v.findViewById(R.id.hargamenu);
            jumlahmenu = v.findViewById(R.id.jumlahe);
            layoutitem = v.findViewById(R.id.layoutitem);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.modul4_menuitem, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Integer index = Integer.valueOf(dataCoffee.get(i).getIndex());
        viewHolder.namamenu.setText(dataCoffee.get(i).getNamamenu());
        viewHolder.hargamenu.setText(dataCoffee.get(i).getHarga());
        viewHolder.jumlahmenu.setText(dataCoffee.get(i).getJumlah());

        final Intent intent = new Intent(mContext, Modul4_menudetailActivity.class);
        intent.putExtra("index",index);
        intent.putExtra("namamenu",dataCoffee.get(i).getNamamenu());
        intent.putExtra("hargamenu",dataCoffee.get(i).getHarga());
        intent.putExtra("jumlahmenu",dataCoffee.get(i).getJumlah());
        viewHolder.layoutitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) mContext).startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataCoffee.size();
    }
}