package com.example.semua;

public class coffee {
    private String namamenu,harga,jumlah;
    private Integer index;
    private Integer total;

    public coffee(Integer index,String namamenu, String harga, String jumlah, Integer total) {
        this.index = index;
        this.namamenu = namamenu;
        this.harga = harga;
        this.jumlah = jumlah;
        this.total = total;
    }
    public Integer getIndex() {
        return index;
    }

    public String getNamamenu() {
        return namamenu;
    }

    public String getHarga() {
        return harga;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
