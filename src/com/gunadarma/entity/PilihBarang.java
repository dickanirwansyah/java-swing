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
public class PilihBarang {
    
    private String idbarang;
    private String nama;
    private int jumlah;
    private int harga;
    private boolean pilih;
    
    public String getIdbarang(){
        return idbarang;
    }
    
    public void setIdbarang(String idbarang){
        this.idbarang = idbarang;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
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
    
    public boolean isPilih(){
        return pilih;
    }
    
    public void setPilih(boolean pilih){
        this.pilih = pilih;
    }

    @Override
    public String toString() {
        return nama;
    }
    
    
}
