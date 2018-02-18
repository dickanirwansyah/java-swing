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
public class LaporanTransaksi {
    
    private Transaksi transaksi;
    
    private TransaksiDetil transaksiDetil;
    
    public Transaksi getTransaksi(){
        return transaksi;
    }
    
    public void setTransaksi(Transaksi transaksi){
        this.transaksi = transaksi;
    }
    
    public TransaksiDetil getTransaksiDetil(){
        return transaksiDetil;
    }
    
    public void setTransaksiDetil(TransaksiDetil transaksiDetil){
        this.transaksiDetil = transaksiDetil;
    }
}
