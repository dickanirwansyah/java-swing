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
public class Barang {
    
    private String idbarang;
    private String nama;
    private int jumlah;
    private int harga;
    
    public Barang(){
        
    }
    
    public Barang(String idbarang, String nama, int jumlah, int harga){
        this.idbarang = idbarang;
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
    }
    
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
        this.harga= harga;
    }
}
