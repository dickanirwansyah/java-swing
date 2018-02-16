/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.entity;

/**
 *
 * @author dickajava
 */
public class TransaksiDetil {
    
    private Transaksi transaksi;
    private PilihBarang barang;
    private int jumlah;
    private int harga;
    
    public Transaksi getTransaksi(){
        return transaksi;
    }
    
    public void setTransaksi(Transaksi transaksi){
        this.transaksi = transaksi;
    }
    
    public PilihBarang getBarang(){
        return barang;
    }
    
    public void setBarang(PilihBarang barang){
        this.barang = barang;
    }
    
    public int getJumlah(){
        return jumlah;
    }
    
    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }
    
    public int getHarga(){
        return harga;
    }
    
    public void setHarga(int harga){
        this.harga = harga;
    }
}
